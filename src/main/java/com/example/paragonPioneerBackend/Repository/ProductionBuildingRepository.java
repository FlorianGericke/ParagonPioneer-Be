package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for populationsBuilding
 */
public interface ProductionBuildingRepository extends JpaRepository<ProductionBuilding, UUID> {

    /**
     * * find a populationBuilding by its name
     * @param name of the population building to find
     * @return the populationBuilding
     */
    ProductionBuilding findByNameIs(String name);
}
