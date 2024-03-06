package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for {@link Good} entities.
 * This interface provides automated CRUD functionalities for goods,
 * leveraging the JpaRepository interface from Spring Data. Additional methods
 * are defined for querying goods by exact names, slugs, or name substrings,
 * enhancing the application's ability to access and manage good data efficiently.
 */
public interface GoodRepository extends JpaRepository<Good, UUID> {

    /**
     * Finds a good by its exact name.
     *
     * @param name The exact name of the good to be found.
     * @return An Optional containing the good if found; otherwise, an empty Optional.
     */
    Optional<Good> findByNameIs(String name);

    /**
     * Finds a good by its slug. Slugs provide a URL-friendly string representation of a good's name.
     *
     * @param slug The slug associated with the good.
     * @return An Optional containing the good if found; otherwise, an empty Optional.
     */
    Optional<Good> findBySlugIs(String slug);

    /**
     * Finds all goods whose names contain the specified substring. This method is useful for implementing
     * search functionalities where a partial match is sufficient.
     *
     * @param name The substring to search for within the names of goods.
     * @return A list of goods that match the specified substring in their names.
     */
    List<Good> findAllByNameContains(String name);
}
