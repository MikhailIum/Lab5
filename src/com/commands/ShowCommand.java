package com.commands;

import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.StudyGroup;

/**
 * shows the whole collection
 */
public class ShowCommand extends Command {
    public ShowCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        if (client.groups.isEmpty())
            System.out.println(TextColor.ANSI_YELLOW + "Collection is empty!!\n" + TextColor.ANSI_RESET);
        else {
            for (StudyGroup group : client.groups) {
                System.out.println(group.toString());
            }
        }
    }

}
