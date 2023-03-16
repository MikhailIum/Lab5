package com.commands;

import com.auxiliary.Hint;
import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.StudyGroup;

/** Remove an element by its name */
public class RemoveCommand extends Command {
  public RemoveCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public void execute(Client client, String[] args) throws Exception {
    if (client.groups.isEmpty()) {
      System.out.println(
          TextColor.ANSI_YELLOW + "The collection is already empty!\n" + TextColor.ANSI_RESET);
      return;
    }
    ExitCommand.isSaved = false;
    if (args.length == 1) {
      Hint.nameHint(args.length, client);
      return;
    }
    StudyGroup to_remove = StudyGroup.findByName(client.groups, args[1]);
    if (to_remove != null) {
      client.groups.remove(to_remove);
      System.out.println("The group has been removed");
    } else {
      System.out.print(TextColor.ANSI_YELLOW + "There is no such a group!\n");
      Hint.nameHint(1, client);
    }
  }
}
