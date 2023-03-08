package com.commands;


import com.client.Client;
import com.study_group.StudyGroup;



public class InfoCommand extends Command {
    public InfoCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
    }

}
