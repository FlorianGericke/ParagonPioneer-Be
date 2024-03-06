package com.example.paragonPioneerBackend.Util;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import java.util.Optional;

/**
 * Utility class providing helper methods for working with {@link Optional} instances,
 * especially in the context of entities derived from {@link BaseEntity}.
 * This class aims to simplify common operations on {@link Optional} entities,
 * such as safely retrieving entity identifiers.
 */
public class OptionalUtil {

    /**
     * Retrieves the string representation of the identifier (ID) from an {@link Optional} entity if present.
     * If the entity is not present (i.e., the {@link Optional} is empty), this method returns an empty string.
     * This approach avoids {@link java.util.NoSuchElementException} and simplifies handling of entity IDs
     * in cases where an entity may or may not be present.
     *
     * @param entity An {@link Optional} wrapper around an entity extending {@link BaseEntity}.
     *               The entity from which to retrieve the ID.
     * @return A string representation of the entity's ID if present; otherwise, an empty string.
     */
    public static String getIdOrEmpty(Optional<? extends BaseEntity> entity) {
        if (entity.isEmpty()) {
            return "";
        }

        var baseEntity = entity.get();
        return baseEntity.getId().toString();
    }
}
