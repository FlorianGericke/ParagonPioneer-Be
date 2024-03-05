package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for {@link PopulationBuilding} entities.
 * Provides automated CRUD operations inherited from JpaRepository,
 * along with a custom method for searching population buildings by their name.
 * This interface simplifies the management of population building data by abstracting
 * database interactions, enabling straightforward data access and manipulation.
 */
public interface PopulationBuildingRepository extends JpaRepository<PopulationBuilding, UUID> {

    /**
     * Searches for a PopulationBuilding entity that exactly matches the specified name.
     * This method is particularly useful for retrieving specific population buildings
     * when the exact name is known, facilitating operations like data validation,
     * lookup, or display in user interfaces.
     *
     * @param name The exact name of the PopulationBuilding to find.
     * @return An Optional containing the found PopulationBuilding if available;
     *         otherwise, an empty Optional.
     */
    Optional<PopulationBuilding> findByNameIs(String name);
}
