package com.commands;

import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.*;
import java.util.ArrayList;import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;import java.util.stream.Collectors;

/** Shows all admins of the groups */
public class ShowAdminsCommand extends Command {
  public ShowAdminsCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    if (client.groups.isEmpty()){
      System.out.println(TextColor.ANSI_YELLOW + "Collection is empty!!\n" + TextColor.ANSI_RESET);
      return;
    }
    Person.changeTabs();
    Location.changeTabs();

    client.groups.stream()
        .map(StudyGroup::getAdmin)
        .sorted(
            new Comparator<Person>() {
              @Override
              public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
              }
            })
        .forEach(admin -> System.out.println(admin.toString()));

    Person.changeTabs();
    Location.changeTabs();
  }
}
