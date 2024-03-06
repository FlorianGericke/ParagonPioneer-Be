package com.example.paragonPioneerBackend.Util;

/**
 * Utility class providing static methods for handling slugs. Slugs are URL-friendly strings that
 * represent names or titles in a format suitable for web URLs. This class includes methods for
 * validating the format of a slug and creating a slug from a given string.
 */
public class SlugUtil {

    /**
     * Validates a slug against a predefined pattern to ensure it is URL-friendly.
     * A valid slug consists only of lowercase letters, numbers, and hyphens to separate words.
     * This method checks the slug against a regular expression to ensure it meets these criteria.
     *
     * @param slug The slug string to validate.
     * @return {@code true} if the slug matches the pattern; {@code false} otherwise.
     */
    public static boolean validateSlug(String slug) {
        String slugPattern = "^[a-z0-9]+(?:-[a-z0-9]+)*$";

        return slug.matches(slugPattern);
    }

    /**
     * Creates a slug from a given string. The input string is converted to lowercase,
     * non-alphanumeric characters are removed, and spaces are replaced with hyphens.
     * The resulting string is then validated to ensure it meets slug criteria.
     * If the resulting slug is not valid, an {@link IllegalStateException} is thrown.
     *
     * @param str The input string from which to create the slug.
     * @return A valid, URL-friendly slug derived from the input string.
     * @throws IllegalStateException If the resulting slug does not meet the required pattern.
     */
    public static String createSlug(String str) {
        String original = str;

        str = str.toLowerCase(); // Convert to lowercase
        str = str.replaceAll("[^a-zA-Z0-9 ]", ""); // Remove non-alphanumeric characters except spaces
        str = str.replaceAll(" ", "-"); // Replace spaces with hyphens

        if (!validateSlug(str)) {
            throw new IllegalStateException("Could not create Slug for " + original);
        }

        return str;
    }
}
