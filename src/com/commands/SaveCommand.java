package com.commands;


import com.client.Client;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SaveCommand extends Command {
    public SaveCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {

    }


}
