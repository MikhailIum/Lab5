package com.auxiliary;

public class Check {

    private static boolean isInteger(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    //TODO: javadoc
    public static boolean checkUpdate(String num) {
        if (!isInteger(num)) {
            System.out.println(TextColor.ANSI_RED + "Please, write a number" + TextColor.ANSI_RESET);
            return false;
        } else {
            int a = Integer.parseInt(num);
            if (a <= 14 && a >= 0) {
                return true;
            } else {
                System.out.println(
                        TextColor.ANSI_RED + "You can use only numbers written above" + TextColor.ANSI_RESET);
                return false;
            }
        }
    }
}
