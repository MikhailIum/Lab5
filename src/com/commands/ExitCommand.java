package com.commands;

import com.auxiliary.TextColor;
import com.client.Client;
import java.util.Objects;
import java.util.Scanner;

/**
 * Asks user if he/she wants to save the file before exit(if the file isn't saved yet) and stops the
 * process
 */
public class ExitCommand extends Command {
  public static boolean isSaved;

  public ExitCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    if (isSaved) System.exit(0);
    else {
      System.out.println(
          TextColor.ANSI_YELLOW
              + "Do you want to save the collection?(yes/no)"
              + TextColor.ANSI_RESET);
      Scanner in = new Scanner(System.in);
      String ans;
      while (!Objects.equals(ans = in.nextLine(), "yes") && !Objects.equals(ans, "no")) {
        System.out.println(
            TextColor.ANSI_RED + "Your answer should be 'yes' or 'no'" + TextColor.ANSI_RESET);
      }
      if (ans.equals("yes")) {
        client.commands.get("save").execute(client, args);
      }
      isSaved = true;
      execute(client, args);
    }
  }
}
