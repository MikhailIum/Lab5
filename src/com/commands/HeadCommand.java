package com.commands;

import com.auxiliary.TextColor;
import com.client.Client;

/** Shows the first element of the collection */
public class HeadCommand extends Command {
  public HeadCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    if (client.groups.isEmpty())
      System.out.println(TextColor.ANSI_YELLOW + "Collection is empty!!\n" + TextColor.ANSI_RESET);
    else System.out.println(client.groups.stream().findFirst());
  }
}
