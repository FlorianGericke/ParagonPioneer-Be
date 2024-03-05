package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
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
    Optional<Population> findByNameIs(String name);

    /**
     * * find a population by its name
     *
     * @param slug of the good to find
     * @return the good
     */
    Optional<Population> findBySlugIs(String slug);


    /**
     * find all population by name contains
     *
     * @param name contained string
     * @return list of all matching
     */
    List<Population> findAllByNameContains(String name);
}

