package com.example.paragonPioneerBackend.Util;

/**
 * StringUtil is a utility class that provides static methods for string manipulation.
 */
public class StringUtil {

    /**
     * Converts a string to lower case.
     * If the input string is null or empty, the method returns null.
     *
     * @param str The string to be converted to lower case.
     * @return The lower case version of the input string, or null if the input string is null or empty.
     */
    public static String toLower(String str) {
        if (str == null || str.isEmpty()){
            return null;
        }

        return str.toLowerCase();
    }
}
