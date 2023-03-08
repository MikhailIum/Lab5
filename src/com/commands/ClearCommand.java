package com.commands;

import com.client.Client;

import java.util.LinkedList;

/**
 * Removes all the groups from the collection
 */
public class ClearCommand extends Command {
    public ClearCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        ExitCommand.isSaved = false;
        client.groups = new LinkedList<>();
        System.out.println("Collection is successfully cleared!");
    }
}
