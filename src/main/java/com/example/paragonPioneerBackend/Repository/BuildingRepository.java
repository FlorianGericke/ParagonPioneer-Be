package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository interface for {@link Building} entities.
 * Provides methods to perform CRUD operations and additional queries to find buildings by name or slug.
 * Inherits standard CRUD and pagination methods from JpaRepository.
 */
public interface BuildingRepository extends JpaRepository<Building, UUID> {

    /**
     * Finds a building exactly matching the specified name.
     *
     * @param name The exact name of the building to find.
     * @return An Optional containing the building if found; otherwise, an empty Optional.
     */
    Optional<Building> findByNameIs(String name);

    /**
     * Finds all buildings where the name contains the specified substring.
     * This method is useful for implementing search functionalities where a partial match is acceptable.
     *
     * @param name The substring to search for within the building names.
     * @return A list of buildings that contain the specified substring in their names.
     */
    List<Building> findAllByNameContains(String name);

    /**
     * Finds a building based on its slug. Slugs are typically used in URLs and are unique for each building.
     *
     * @param slug The slug of the building to find.
     * @return An Optional containing the building if a matching slug is found; otherwise, an empty Optional.
     */
    Optional<Building> findBySlugIs(String slug);
}
