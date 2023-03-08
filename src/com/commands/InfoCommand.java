package com.commands;


import com.client.Client;
import com.study_group.StudyGroup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.ObjectUtils.max;

/**
 * Shows information about the collection
 */
public class InfoCommand extends Command {
    public InfoCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        LocalDateTime last_update = LocalDateTime.MIN;
        for (StudyGroup group : client.groups) {
            last_update = max(last_update, group.getCreationDate());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");


        System.out.println("Collection name: Study Group, number of elements: " + client.groups.size());
        assert last_update != null;
        if (!client.groups.isEmpty())
            System.out.println("Last update: " + last_update.format(formatter) + "\n");
    }

}
