package com.auxiliary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Check {
    private static boolean isDouble(String x) {
        return true;
    }

    private static boolean isFloat(String x) {
        return true;
    }

    private static boolean isLong(String x) {
        return true;
    }

    public static boolean checkName(String name) {
        return true;
    }

    public static boolean checkCoords(String coords, String del) {
        return true;
    }

    public static boolean checkStudentsCount(String num, String field) {
        return true;
    }

    public static boolean checkSemester(String num) {
        return true;
    }

    public static boolean checkBirthday(String date) {
        return true;
    }

    public static boolean checkHairColor(String num) {
        return true;
    }

    public static boolean checkNationality(String num) {
        return true;
    }

    public static boolean checkCoordinate(String x, String type) {
        return true;
    }

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
