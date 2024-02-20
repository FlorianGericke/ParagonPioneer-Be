package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for populationBuildings
 */
public interface PopulationBuildingRepository extends JpaRepository<PopulationBuilding, UUID> {

    /**
     * * find a PopulationBuilding by its name
     * @param name of the PopulationBuilding to find
     * @return the PopulationBuilding
     */
    Optional<PopulationBuilding>  findByNameIs(String name);
}
