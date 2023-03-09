package com.auxiliary;

import com.client.Client;

/**
 * Gives user a hint about what he\she can print
 */
public class Hint {

    /**
     * Gives a hint if the user forgot to print an argument
     * @param numberOfArgs - number of arguments putted by the user
     */
    private static void checkHasAnArgument(int numberOfArgs){
        if (numberOfArgs == 1){
            System.out.println(TextColor.ANSI_YELLOW + "This command should have an argument");
        }
    }

    /**
     * Gives a hint about names of the groups
     */
    public static void nameHint(int numberOfArgs, Client client){
        checkHasAnArgument(numberOfArgs);
        System.out.print("Possible names:\n" + "{");
        for (int i = 0; i < client.groups.size()-1; i++) {
            System.out.print(client.groups.get(i).getName() + ", ");
        }
        System.out.print(client.groups.getLast().getName());
        System.out.println("}" + TextColor.ANSI_RESET);
    }

}
