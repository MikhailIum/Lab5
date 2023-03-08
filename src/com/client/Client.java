package com.client;
import com.auxiliary.CommandMapMaker;
import com.auxiliary.Listener;
import java.util.LinkedList;
import java.util.Map;

import com.commands.Command;
import com.study_group.StudyGroup;

public class Client implements Listener {


    public LinkedList<StudyGroup> groups;
    public String FILE_PATH = System.getenv("FILE_PATH");
    public Map<String, Command> commands;

    @Override
    public void start() {
        commands = CommandMapMaker.makeDefault();
    }

    /**
     * Listening from terminal stream
     */
    @Override
    public void listen() {

    }

    @Override
    public void finish() {
    }

    public void executeCommands(String[] line){

    }


}
