package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for populations
 */
public interface PopulationRepository extends JpaRepository<Population, UUID> {

    /**
     * * find a populations by its name
     * @param name of the population to find
     * @return the population
     */
    public Population findByNameIs(String name);
}

