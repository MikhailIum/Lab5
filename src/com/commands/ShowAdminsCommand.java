package com.commands;



import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.*;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Shows all admins of the groups
 */
public class ShowAdminsCommand extends Command {
    public ShowAdminsCommand(String name, String description) {
        super(name, description);
    }

    /**
     * Get all admins from the collection
     * @param groups - collection
     * @return list of admins
     */
    private LinkedList<Person> getAdmins(LinkedList<StudyGroup> groups){
        LinkedList<Person> admins = new LinkedList<>();
        if (groups.isEmpty())
            System.out.println(TextColor.ANSI_YELLOW + "Collection is empty!!\n" + TextColor.ANSI_RESET);

        for (StudyGroup group : groups) {
            admins.add(group.getAdmin());
        }

        admins.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return admins;
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        LinkedList<Person> admins = getAdmins(client.groups);

        Person.changeTabs();
        Location.changeTabs();
        for (Person admin : admins) {
            System.out.println(admin.toString());
        }
        Person.changeTabs();
        Location.changeTabs();
    }


}

