package com.commands;


import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.*;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Shows admins whose names lexicographically greater than given
 */
public class FilterAdminCommand extends Command {
    public FilterAdminCommand(String name, String description) {
        super(name, description);
    }

    /**
     * Returns admins whose names lexicographically greater than given
     * @param client - user
     * @param name - given name
     * @return list of admins
     */
    private LinkedList<Person> getRightAdmins(Client client, String name){
        LinkedList<Person> admins = new LinkedList<>();
        for (StudyGroup group : client.groups) {
            admins.add(group.getAdmin());
        }

        LinkedList<Person> rightAdmins = new LinkedList<>();
        for (Person admin : admins) {
            if (name.compareTo(admin.getName()) < 0){
                rightAdmins.add(admin);
            }
        }

        return rightAdmins;
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print(TextColor.ANSI_PURPLE + "Name" + TextColor.ANSI_BLUE + "(string)" + TextColor.ANSI_PURPLE + ": " + TextColor.ANSI_RESET);
        String name = in.nextLine();

        LinkedList<Person> rightAdmins = getRightAdmins(client, name);
        if (rightAdmins.isEmpty()){
            System.out.println(TextColor.ANSI_YELLOW + "Nothing was found\n" + TextColor.ANSI_RESET);
        } else {
            Person.changeTabs();
            Location.changeTabs();
            for (Person rightAdmin : rightAdmins) {
                System.out.println(rightAdmin);
            }
            Person.changeTabs();
            Location.changeTabs();
        }
    }


}