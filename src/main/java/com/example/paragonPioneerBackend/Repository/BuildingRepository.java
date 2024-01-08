package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for building
 */
public interface BuildingRepository extends JpaRepository<Building, UUID> {

    /**
     * find a building by its name
     * @param name of the building to find
     * @return the building
     */
    public Building findByNameIs(String name);
}
