package com.example.paragonPioneerBackend.Util;

public class StringUtil {
    public static String toLower(String str) {
        if (str == null || str.isEmpty()){
            return null;
        }

        return str.toLowerCase();
    }
}
