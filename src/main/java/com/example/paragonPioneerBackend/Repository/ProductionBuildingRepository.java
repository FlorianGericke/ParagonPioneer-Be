package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for {@link ProductionBuilding} entities.
 * This interface provides automated CRUD functionalities inherited from JpaRepository,
 * along with a custom method for querying production buildings by their exact name.
 * It simplifies the management of production building data by abstracting direct database interactions,
 * enabling straightforward data access and manipulation.
 */
public interface ProductionBuildingRepository extends JpaRepository<ProductionBuilding, UUID> {

    /**
     * Searches for a ProductionBuilding entity that exactly matches the specified name.
     * This method is particularly useful for retrieving specific production buildings
     * when the exact name is known, facilitating operations like data validation, lookup,
     * or display in user interfaces.
     *
     * @param name The exact name of the production building to find.
     * @return An Optional containing the found production building if available;
     *         otherwise, an empty Optional.
     */
    Optional<ProductionBuilding> findByNameIs(String name);
}
