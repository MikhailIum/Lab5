package com.commands;


import com.auxiliary.TextColor;
import com.client.Client;
import com.study_group.StudyGroup;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Saves the collection to the file
 */
public class SaveCommand extends Command {
    public SaveCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Client client, String[] args) throws Exception {
        if(ExitCommand.isSaved){
            System.out.println(TextColor.ANSI_YELLOW + "Collection is already saved\n" + TextColor.ANSI_RESET);
            return;
        }
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(client.FILE_PATH));

        client.groups.stream()
        .forEach(
            group -> {
              try {
                out.write(group.getParams());
              } catch (IOException e) {
                throw new RuntimeException(e);
              }
            });

        System.out.println("Collection is successfully saved!\n");
        ExitCommand.isSaved = true;
        out.close();
    }


}
