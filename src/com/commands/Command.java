package com.commands;
import com.client.Client;

import java.io.IOException;


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


    public abstract void execute(Client client, String[] args) throws Exception;


}