package com.auxiliary;

import com.client.Client;
import com.study_group.StudyGroup;
import java.util.Iterator;
import java.util.stream.Collectors;

/** Gives user a hint about what he\she can print */
public class Hint {

  /**
   * Gives a hint if the user forgot to print an argument
   *
   * @param numberOfArgs - number of arguments putted by the user
   */
  private static void checkHasAnArgument(int numberOfArgs) {
    if (numberOfArgs == 1) {
      System.out.println(TextColor.ANSI_YELLOW + "This command should have an argument");
    }
  }

  /** Gives a hint about names of the groups */
  public static void nameHint(int numberOfArgs, Client client) {
    checkHasAnArgument(numberOfArgs);
    System.out.print("Possible names:\n" + "{");

    client.groups.stream()
        .limit(client.groups.size() - 1)
        .forEach(studyGroup -> System.out.print(studyGroup.getName() + ", "));

    System.out.print(client.groups.getLast().getName());
    System.out.println("}" + TextColor.ANSI_RESET);
  }
}
