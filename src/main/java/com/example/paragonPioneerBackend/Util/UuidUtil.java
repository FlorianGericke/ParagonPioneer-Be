package com.example.paragonPioneerBackend.Util;

import java.util.UUID;

public class UuidUtil {
    public static UUID parseUuidFromStringOrNull(String uuidStr) {
        var uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
        if (uuidStr == null){
            return null;
        }
        if (!uuidStr.matches(uuidRegex)) {
            return null;
        }

        return UUID.fromString(uuidStr);
    }
}
