package com.commands;


import com.auxiliary.TextColor;
import com.client.Client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Puts lines from a given file to the input stream(like if user would write them)
 */
public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println(TextColor.ANSI_YELLOW + "You should print path to the script\n" + TextColor.ANSI_RESET);
            return;
        }
        String filename = args[1];
        Scanner in;
        try {
            in = new Scanner(new InputStreamReader(new FileInputStream(filename)));
        } catch (FileNotFoundException ex){
            System.out.println(TextColor.ANSI_YELLOW + "There is no such a file\n" + TextColor.ANSI_RESET);
            return;
        }
        while (in.hasNext()){
            String lineToShow = in.nextLine();
            System.out.println(TextColor.ANSI_GREEN + lineToShow + TextColor.ANSI_RESET);
            client.executeCommands(lineToShow.split(" "));
        }
    }

}
