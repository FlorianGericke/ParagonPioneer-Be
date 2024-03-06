package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository interface for {@link Population} entities.
 * This repository extends JpaRepository to provide standardized CRUD operations and
 * extends functionality with custom query methods for finding populations by specific criteria.
 * It supports operations such as finding a population by name or slug and searching for populations
 * based on a name substring, enhancing the application's ability to interact with population data.
 */
public interface PopulationRepository extends JpaRepository<Population, UUID> {

    /**
     * Finds a specific population by its exact name.
     *
     * @param name The exact name of the population to find.
     * @return An Optional containing the population if found; otherwise, an empty Optional.
     */
    Optional<Population> findByNameIs(String name);

    /**
     * Finds a population by its slug. Slugs provide a URL-friendly string representation of a population's name,
     * typically used for identification in web interfaces.
     *
     * @param slug The slug of the population to find.
     * @return An Optional containing the population if found; otherwise, an empty Optional.
     */
    Optional<Population> findBySlugIs(String slug);

    /**
     * Finds all populations whose names contain the specified substring.
     * This method is useful for implementing search functionalities within the application,
     * allowing for the retrieval of populations based on partial name matches.
     *
     * @param name The substring to search for within the names of populations.
     * @return A list of populations that contain the specified substring in their names.
     */
    List<Population> findAllByNameContains(String name);
}
