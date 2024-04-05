package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Spring Data JPA repository for {@link PopulationRequirement} entities.
 * This interface facilitates the creation, retrieval, update, and deletion (CRUD) of population requirement relations,
 * along with providing automatic pagination and sorting capabilities. The {@link PopulationRequirement} entity
 * represents the many-to-many relationship between populations and their specific requirements, such as goods
 * consumption or production rates.
 *
 * This repository abstracts the underlying data storage mechanism, enabling easy access and manipulation of
 * population requirement data without directly dealing with database queries.
 */
public interface PopulationRequirementRepository extends JpaRepository<PopulationRequirement, UUID> {

    /**
     * This method retrieves a list of population requirements based on the provided population ID.
     *
     * @param populationId The ID of the population for which to retrieve requirements.
     * @return A list of population requirements associated with the specified population ID.
     */
    List<PopulationRequirement> findByPopulationId(UUID populationId);
}
