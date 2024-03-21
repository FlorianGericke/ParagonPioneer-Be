package com.example.paragonPioneerBackend.Util;

import java.util.UUID;

/**
 * Utility class for operations related to {@link UUID}s. Provides methods for parsing UUIDs from strings,
 * including validation to ensure the string is in a valid UUID format before attempting to parse it.
 * This class aims to simplify the handling and validation of UUID strings within the application.
 */
public class UuidUtil {

    /**
     * Attempts to parse a UUID from a given string. The method validates the string against a UUID format
     * regular expression before parsing. If the string does not match the expected UUID format, {@code null}
     * is returned instead of throwing an exception.
     *
     * This approach allows for safe parsing of UUIDs from strings that may not be properly formatted,
     * making it useful in situations where UUID strings come from external sources or user input.
     *
     * @param uuidStr The string representation of the UUID to parse.
     * @return A {@link UUID} object if the string is in a valid UUID format; {@code null} otherwise.
     */
    public static UUID parseUuidFromStringOrNull(String uuidStr) {
        // Regular expression to validate the UUID string format.
        var uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
        if (uuidStr == null){
            return null;
        }

        // Check if the UUID string matches the UUID format.
        if (!uuidStr.matches(uuidRegex)) {
            return null; // Return null if the string does not match the UUID format.
        }

        // Return the parsed UUID if the string is in the correct format.
        return UUID.fromString(uuidStr);
    }
}
