package com.commands;

import com.client.Client;

/**
 * Gives a list of possible commands Called when user prints the text that does not correspond to
 * any of the possible commands
 */
public class HelpCommand extends Command {

  public HelpCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    for (Command command : client.commands.values()) {
      System.out.println(command.getName() + ": " + command.getDescription());
    }
    System.out.println();
  }
}
