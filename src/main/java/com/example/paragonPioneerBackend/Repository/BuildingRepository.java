package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for building
 */
public interface BuildingRepository extends JpaRepository<Building, UUID> {

    /**
     * find a building by its name
     *
     * @param name of the building to find
     * @return the building
     */
    Optional<Building> findByNameIs(String name);

    /**
     * find all building by name contains
     *
     * @param name contained string
     * @return list of all matching
     */
    List<Building> findAllByNameContains(String name);

    /**
     * * find a Good by its name
     *
     * @param slug of the good to find
     * @return the good
     */
    Optional<Building> findBySlugIs(String slug);
}
