package com.commands;


import com.client.Client;

import java.util.Objects;
import java.util.Scanner;

public class ExitCommand extends Command {
    public ExitCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {

    }


}
