package com.commands;

import com.auxiliary.TextColor;
import com.client.Client;

/** Removes first group from the collection(lexicographically first) */
public class RemoveFirstCommand extends Command {
  public RemoveFirstCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    ExitCommand.isSaved = false;
    if (!client.groups.isEmpty()) {
      client.groups.removeFirst();
      System.out.println("First element has been removed");
    } else {
      System.out.println(TextColor.ANSI_YELLOW + "Collection is empty!!\n" + TextColor.ANSI_RESET);
    }
  }
}
