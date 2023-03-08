package com.commands;


import com.client.Client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {

    }

}
