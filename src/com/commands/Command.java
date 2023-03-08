package com.commands;
import com.client.Client;


/**
 * Abstract class for commands which user can execute to manipulate with a collection
 */
public abstract class Command {
    private final String name;
    private final String description;


    public Command(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }


    /**
     * Method called when user print the command's name
     */
    public abstract void execute(Client client, String[] args) throws Exception;


}
