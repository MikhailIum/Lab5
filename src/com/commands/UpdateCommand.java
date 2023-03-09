package com.commands;


import com.auxiliary.Check;
import com.auxiliary.Hint;
import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.StudyGroup;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UpdateCommand extends Command {
    public UpdateCommand(String name, String description) {
        super(name, description);
    }


    /**
     * Updates the chosen group
     * @param toUpdate - groups the user wants to be updated
     */
    private void update(StudyGroup toUpdate) throws IOException {
        System.out.println(TextColor.ANSI_YELLOW + "Chosen group:" + TextColor.ANSI_RESET);
        System.out.println(toUpdate);
        String num = "7";
        while (!Objects.equals(num, "0")) {
            System.out.println(TextColor.ANSI_YELLOW + "What do you want to update:");
            System.out.println("0 - nothing, stop updating\n1 - name\n2 - coordinates\n3 - number of students\n" +
                    "4 - expelled students\n5 - should be expelled\n6 - semester\n7 - admin's name\n" +
                    "8 - admin's birthday\n9 - admin's hair color\n10 - admin's nationality\n" +
                    "11 - admin's location x coordinate\n12 - admin's location y coordinate\n" +
                    "13 - admin's location z coordinate\n14 - admin location's name" + TextColor.ANSI_RESET);

            Scanner in = new Scanner(System.in);
            while (!Check.checkUpdate((num = in.nextLine()))) {
            }
            if (!Objects.equals(num, "0")){
                toUpdate.updateField(Integer.parseInt(num));
            }
        }
        System.out.println("The group has been updated");
    }

    /**
     * Enables update mode, where user can choose which fields he/she wants to change
     */
    @Override
    public void execute(Client client, String[] args) throws Exception {
        ExitCommand.isSaved = false;
        Hint.nameHint(args.length, client);

        StudyGroup toUpdate = StudyGroup.findByName(client.groups, args[1]);
        if (toUpdate != null){
            update(toUpdate);
        } else {
            System.out.print(TextColor.ANSI_YELLOW + "There is no such a group!\n" + "Possible names:\n" + "{");
            Hint.nameHint(1, client);
        }
    }


}
