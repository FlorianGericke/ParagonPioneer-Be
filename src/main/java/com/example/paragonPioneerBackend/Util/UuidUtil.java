package com.example.paragonPioneerBackend.Util;

import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Exception.CastException;

import java.util.Set;
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
     * <p>
     * This approach allows for safe parsing of UUIDs from strings that may not be properly formatted,
     * making it useful in situations where UUID strings come from external sources or user input.
     *
     * @param uuidStr The string representation of the UUID to parse.
     * @return A {@link UUID} object if the string is in a valid UUID format; {@code null} otherwise.
     */
    public static UUID validateOrNull(String uuidStr) {
        // Regular expression to validate the UUID string format.
        var uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
        if (uuidStr == null) {
            return null;
        }

        // Check if the UUID string matches the UUID format.
        if (!uuidStr.matches(uuidRegex)) {
            return null; // Return null if the string does not match the UUID format.
        }

        // Return the parsed UUID if the string is in the correct format.
        return UUID.fromString(uuidStr);
    }

    /**
     * This method is used to generate IRIs (Internationalized Resource Identifiers) for a set of entities.
     * It takes a prefix and a set of entities as parameters. The prefix is prepended to the ID of each entity
     * to form the IRI. If the set of entities is null or empty, the method returns null.
     *
     * @param prefix   The prefix to be prepended to each entity's ID to form the IRI.
     * @param entities The set of entities for which to generate IRIs.
     * @return An array of IRIs for the entities. If the set of entities is null or empty, returns null.
     */
    public static String[] getIri(String prefix, Set<? extends BaseEntity> entities) {
        return entities == null || entities.isEmpty() ? null : entities.stream().map(e -> EnvironmentUtil.getApiBaseUrl() + prefix + e.getId()).toArray(String[]::new);
    }

    /**
     * This method is used to generate an IRI (Internationalized Resource Identifier) for a single entity.
     * It takes a prefix and an entity as parameters. The prefix is prepended to the ID of the entity
     * to form the IRI. If the entity is null, the method returns null.
     *
     * @param prefix The prefix to be prepended to the entity's ID to form the IRI.
     * @param entity The entity for which to generate an IRI.
     * @return The IRI for the entity. If the entity is null, returns null.
     */
    public static String getIri(String prefix, BaseEntity entity) {
        return entity == null ? null : EnvironmentUtil.getApiBaseUrl() + prefix + entity.getId();
    }

    /**
     * This method is used to parse a UUID from a given string or IRI (Internationalized Resource Identifier).
     * It first attempts to parse the UUID from the input string using the validateOrNull method.
     * If the input string is not a valid UUID, it assumes the string is an IRI and attempts to extract the UUID from it.
     * The UUID is assumed to be the substring after the last "/" character in the IRI.
     * If the extraction fails, a CastException is thrown with a message indicating the input string could not be parsed.
     *
     * @param idOrIri The string or IRI from which to extract the UUID.
     * @return A UUID parsed from the input string or IRI.
     * @throws CastException If the input string is not a valid UUID or IRI, or if the UUID cannot be extracted from the IRI.
     */
    public static UUID getFromString(String idOrIri) {
        UUID id = UuidUtil.validateOrNull(idOrIri);
        if (id == null) {
            try {
                id = UuidUtil.validateOrNull(idOrIri.substring(idOrIri.lastIndexOf("/") + 1));
            } catch (Exception e) {
                throw new CastException("Cannot parse " + idOrIri);
            }
        }
        return id;
    }
}