package com.example.paragonPioneerBackend.Util;

public class SlugUtil {
    public static boolean validateSlug(String slug) {
        String slugPattern = "^[a-z0-9]+(?:-[a-z0-9]+)*$";

        return slug.matches(slugPattern);
    }

    public static String createSlug(String str) {
        String original = str;

        str = str.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9 ]", "");
        str = str.replaceAll(" ", "-");

        if (!validateSlug(str)) {
            throw new IllegalStateException("Could not create Slug for" + original);
        }

        return str;
    }
}
