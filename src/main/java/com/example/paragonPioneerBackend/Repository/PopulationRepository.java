package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for populations
 */
public interface PopulationRepository extends JpaRepository<Population, UUID> {

    /**
     * * find a populations by its name
     *
     * @param name of the population to find
     * @return the population
     */
    Population findByNameIs(String name);

    /**
     * find all population by name contains
     *
     * @param name contained string
     * @return list of all matching
     */
    List<Population> findAllByNameContains(String name);
}

