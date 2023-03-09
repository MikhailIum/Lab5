package com.commands;


import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.StudyGroup;

import java.util.LinkedList;


/**
 * Shows those groups which names contain certain substring
 */
public class FilterNameCommand extends Command {
    public FilterNameCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        if (args.length == 1){
            System.out.println(TextColor.ANSI_YELLOW + "This command should have an argument");
            return;
        }
        String name = args[1];
        boolean ifGroupExists = false;
        for (StudyGroup group : client.groups) {
            if (group.getName().contains(name)){
                System.out.println(group);
                ifGroupExists = true;
            }
        }
        if (!ifGroupExists){
            System.out.println(TextColor.ANSI_YELLOW + "There aren't groups with a name contains this string\n" + TextColor.ANSI_RESET);
        }
    }


}
