package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for populationBuildings
 */
public interface PopulationBuildingRepository extends JpaRepository<PopulationBuilding, UUID> {
    public PopulationBuilding findByNameIs(String name);
}
