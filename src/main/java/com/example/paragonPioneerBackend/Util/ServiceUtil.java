package com.example.paragonPioneerBackend.Util;

import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Slugable;
import com.example.paragonPioneerBackend.Exception.CastException;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.SlugableReposetory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Utility class for operations related to services. Provides methods for updating entity fields based on patch requests,
 * as well as methods for retrieving entities from repositories based on entity IDs or slugs.
 */
public class ServiceUtil {
    /**
     * This helper method is used to determine which String value should be used between two given String values.
     * It checks if the 'next' value is null or empty. If either condition is true, it returns the 'toUpdate' value.
     * Otherwise, it returns the 'next' value. This method is useful when you want to update a value but also want to preserve the original value under certain conditions.
     *
     * @param toUpdate The original String value that might be updated.
     * @param next     The new String value that might replace the original value.
     * @return The original String value if 'next' is null or empty, otherwise the new String value.
     */
    public static String patchHelper(String toUpdate, String next) {
        return (next == null || next.isEmpty()) ? toUpdate : next;
    }

    /**
     * This helper method is used to determine which Boolean value should be used between two given Boolean values.
     * It checks if the 'next' value is null. If it is true, it returns the 'toUpdate' value.
     * Otherwise, it returns the 'next' value. This method is useful when you want to update a value but also want to preserve the original value under certain conditions.
     *
     * @param toUpdate The original Boolean value that might be updated.
     * @param next     The new Boolean value that might replace the original value.
     * @return The original Boolean value if 'next' is null, otherwise the new Boolean value.
     */
    public static boolean patchHelper(Boolean toUpdate, Boolean next) {
        return (next == null) ? toUpdate : next;
    }

    /**
     * This helper method is used to determine which float value should be used between two given float values.
     * It checks if the 'next' value is null or if the 'toUpdate' value is 0. If either condition is true, it returns the 'toUpdate' value.
     * Otherwise, it returns the 'next' value. This method is useful when you want to update a value but also want to preserve the original value under certain conditions.
     *
     * @param toUpdate The original float value that might be updated.
     * @param next     The new float value that might replace the original value.
     * @return The original float value if 'next' is null or 'toUpdate' is 0, otherwise the new float value.
     */
    public static float patchHelper(Float toUpdate, Float next) {
        return (next == null || toUpdate == 0f) ? toUpdate : next;
    }

    /**
     * This helper method is used to determine which Integer value should be used between two given Integer values.
     * It checks if the 'next' value is null or if the 'toUpdate' value is 0. If either condition is true, it returns the 'toUpdate' value.
     * Otherwise, it returns the 'next' value. This method is useful when you want to update a value but also want to preserve the original value under certain conditions.
     *
     * @param toUpdate The original Integer value that might be updated.
     * @param next     The new Integer value that might replace the original value.
     * @return The original Integer value if 'next' is null or 'toUpdate' is 0, otherwise the new Integer value.
     */
    public static int patchHelper(Integer toUpdate, Integer next) {
        return (next == null || toUpdate == 0f) ? toUpdate : next;
    }

    /**
     * This helper method is used to determine which BaseEntity value should be used between two given BaseEntity values.
     * It checks if the 'nextID' value is null. If it is true, it returns the 'toUpdate' value.
     * Otherwise, it attempts to find the BaseEntity in the repository using the 'nextID'. If the BaseEntity is not found, it throws an EntityNotFoundException.
     * This method is useful when you want to update a value but also want to preserve the original value under certain conditions.
     *
     * @param <Type>     The type of the BaseEntity.
     * @param toUpdate   The original BaseEntity value that might be updated.
     * @param entity     The ID of the new BaseEntity that might replace the original value.
     * @param repository The JpaRepository where the BaseEntity is stored.
     * @return The original BaseEntity value if 'nextID' is null, otherwise the new BaseEntity value.
     * @throws EntityNotFoundException if the BaseEntity with the 'nextID' is not found in the repository.
     */
    public static <Type extends BaseEntity> Type patchHelper(Type toUpdate, String entity, JpaRepository<Type, UUID> repository) {
        return entity == null ? toUpdate : repository.findById(UuidUtil.getFromString(entity)).orElseThrow(() -> new EntityNotFoundException(UUID.fromString(entity)));
    }

    /**
     * This helper method is used to retrieve a Slugable entity from the repository.
     * It first tries to parse the provided entity string as a UUID. If successful, it attempts to find the entity in the repository by its UUID.
     * If the entity string cannot be parsed as a UUID, it assumes the string is a slug and attempts to find the entity in the repository by its slug.
     * If the entity is not found in the repository by either its UUID or slug, it throws an EntityNotFoundException.
     *
     * @param <Type>     The type of the Slugable entity.
     * @param entity     The string that represents the UUID or slug of the entity.
     * @param repository The SlugableReposetory where the Slugable entity is stored.
     * @return The Slugable entity if found in the repository.
     * @throws CastException if the Slugable entity is not found in the repository.
     */
    public static <Type extends Slugable> Type getHelper(String entity, SlugableReposetory<Type> repository) {
        if (entity == null || entity.isEmpty()) {
            return null;
        }
        UUID identifier = UuidUtil.getFromString(entity);
        if (identifier != null) {
            return repository.findById(identifier).orElseThrow(() -> new EntityNotFoundException(identifier));
        }
        return repository.findBySlug(entity).orElseGet(() -> {
            var list = repository.findAllByName(entity);
            if (list.isEmpty()) {
                throw new CastException("Cannot parse " + entity);
            }
            return list.get(0);
        });
    }

    /**
     * This method is used to retrieve a set of BaseEntity instances from the repository using an array of strings that represent the entities' IDs.
     * It first checks if the entity array is null. If it is, it returns null.
     * It then streams the entity array, filters out any blank strings, and maps each string to a UUID using the UuidUtil.getFromString method.
     * For each UUID, it attempts to find the corresponding BaseEntity in the repository. If the BaseEntity is not found, it throws an EntityNotFoundException.
     * It collects all the found BaseEntity instances into a set and returns it.
     *
     * @param <Type>     The type of the BaseEntity.
     * @param entity     The array of strings that represent the IDs of the entities.
     * @param repository The JpaRepository where the BaseEntity instances are stored.
     * @return A set of BaseEntity instances if found in the repository, or null if the entity array is null.
     * @throws EntityNotFoundException if a BaseEntity with a given UUID is not found in the repository.
     */
    public static <Type extends BaseEntity> Set<Type> getHelper(String[] entity, JpaRepository<Type,UUID> repository) {
        if (entity == null) {
            return null;
        }
        return Arrays.stream(entity).filter(str -> !str.isBlank()).map(UuidUtil::getFromString).map(id->
                repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id))
        ).collect(Collectors.toSet());
    }

    /**
     * This method is used to retrieve a Slugable entity from the repository using a given string that represents the entity's ID or slug.
     * It first checks if the entity string is null or empty. If either condition is true, it throws a CastException.
     * It then tries to parse the entity string as a UUID. If successful, it attempts to find the entity in the repository by its UUID.
     * If the entity string cannot be parsed as a UUID, it attempts to find the entity in the repository by its slug.
     * If the entity is not found in the repository by either its UUID or slug, it throws the exception that was caught when trying to parse the entity string as a UUID.
     *
     * @param <Type>     The type of the Slugable entity.
     * @param entity     The string that represents the UUID or slug of the entity.
     * @param repository The SlugableReposetory where the Slugable entity is stored.
     * @return The Slugable entity if found in the repository.
     * @throws CastException if the entity string is null or empty, or if the entity is not found in the repository by either its UUID or slug.
     * @throws EntityNotFoundException if the Slugable entity with the parsed UUID is not found in the repository.
     */
    public static <Type extends Slugable> Type getHelperNoNull(String entity, SlugableReposetory<Type> repository) {
        if (entity == null || entity.isEmpty()) {
            throw new CastException("Cannot parse " + entity);
        }
        try {
            return repository.findById(UuidUtil.getFromString(entity)).orElseThrow(() -> new EntityNotFoundException(UUID.fromString(entity)));
        } catch (CastException e) {
            return repository.findBySlug(entity).orElseThrow(() -> e);
        }
    }

    /**
     * This method is used to apply a function to a given string representing an entity ID or slug.
     * If the function throws an exception, the method catches it and returns null.
     * This method is useful when you want to perform an operation that might throw an exception, but you want to handle the exception and return a default value instead.
     *
     * @param <T>          The type of the BaseEntity.
     * @param function     The function to be applied to the entityIdSlug.
     * @param entityIdSlug The string that represents the ID or slug of the entity.
     * @return The result of applying the function to the entityIdSlug, or null if the function throws an exception.
     */
    public static <T extends BaseEntity> T ifErrorThenNull(Function<String, T> function, String entityIdSlug) {
        try {
            return function.apply(entityIdSlug);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * This method is used to apply a function to a given array of strings representing entity IDs or slugs.
     * It attempts to apply the function to the entityIdSlug array. If the function throws an exception, the method catches it and returns null.
     * This method is useful when you want to perform an operation that might throw an exception, but you want to handle the exception and return a default value instead.
     *
     * @param <T>          The type of the BaseEntity.
     * @param function     The function to be applied to the entityIdSlug array.
     * @param entityIdSlug The array of strings that represent the IDs or slugs of the entities.
     * @return The result of applying the function to the entityIdSlug array, or null if the function throws an exception.
     */
    public static <T extends BaseEntity> Set<T> ifErrorThenNull(Function<String[], Set<T>> function, String[] entityIdSlug) {
        try {
            return function.apply(entityIdSlug);
        } catch (Exception e) {
            return null;
        }
    }
}