package com.commands;

import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.*;
import java.util.ArrayList;import java.util.LinkedList;
import java.util.Scanner;import java.util.stream.Collectors;

/** Shows admins whose names lexicographically greater than given */
public class FilterAdminCommand extends Command {
  public FilterAdminCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    System.out.print(
        TextColor.ANSI_PURPLE
            + "Name"
            + TextColor.ANSI_BLUE
            + "(string)"
            + TextColor.ANSI_PURPLE
            + ": "
            + TextColor.ANSI_RESET);
    String name = in.nextLine();

    ArrayList<Person> rightAdmins =
        (ArrayList<Person>)
            client.groups.stream()
                .map(StudyGroup::getAdmin)
                .filter(admin -> name.compareTo(admin.getName()) < 0)
                .collect(Collectors.toList());

    if (rightAdmins.isEmpty()) {
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
