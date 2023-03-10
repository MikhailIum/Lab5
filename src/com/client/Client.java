package com.client;
import com.auxiliary.CSVReader;
import com.auxiliary.CommandMapMaker;
import com.auxiliary.Listener;

import java.io.*;
import java.util.*;

import com.auxiliary.TextColor;
import com.commands.Command;
import com.opencsv.bean.CsvToBeanBuilder;
import com.study_group.StudyGroup;

public class Client implements Listener {


    public LinkedList<StudyGroup> groups;
    public String FILE_PATH = System.getenv("FILE_PATH");
    public Map<String, Command> commands;
    List<CSVReader> beans;

    @Override
    public void start() {
        commands = CommandMapMaker.makeDefault();
        try {
            FileReader fr = new FileReader(FILE_PATH);
            beans = new CsvToBeanBuilder(fr)
                    .withType(CSVReader.class)
                    .build()
                    .parse();
            groups = CSVReader.makeCollection(beans);
        } catch (NullPointerException | IOException ex){
            System.out.println(TextColor.ANSI_YELLOW + "You should add environment variable as a path to the file:");
            System.out.println("Write \"export FILE_PATH=(path to file)\" before starting" + TextColor.ANSI_RESET);
            System.exit(0);
        }
    }

    /**
     * Listening from terminal stream
     */
    @Override
    public void listen() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = new String[0];
        commands.get("info").execute(this, line);
        while (true){
            try{
                line = in.readLine().split(" ");

                if (line.length != 0)
                    executeCommands(line);
            } catch (Exception ex){
                System.out.println("\n" + TextColor.ANSI_YELLOW + "Ooops...something went wrong :(" + TextColor.ANSI_RESET);
                System.exit(0);
            }
        }
    }


    /**
     * Calls execution methods for commands
     * @param line - user input
     */
    public void executeCommands(String[] line) throws Exception {
        if (commands.containsKey(line[0])) {
            commands.get(line[0]).execute(this, line);
            groups.sort(new Comparator<StudyGroup>() {
                @Override
                public int compare(StudyGroup o1, StudyGroup o2) {
                    return o1.getName().compareTo(o2.getName());
                }

                @Override
                public boolean equals(Object obj) {
                    return obj.equals(this);
                }
            });
        }
        else if (!Objects.equals(line[0], "")){
            System.out.println("Use 'help' to see possible commands");
        }
    }


}
