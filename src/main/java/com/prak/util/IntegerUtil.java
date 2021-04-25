package com.prak.util;

public class IntegerUtil {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

}
