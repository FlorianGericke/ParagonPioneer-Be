package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Service.PopulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A component designed to seed the application's database with initial population data.
 * Utilizes the PopulationService to create population entities based on a predefined list
 * of population segments. This seeding process is crucial for initializing the application
 * with a baseline dataset that supports functionalities related to population management,
 * resource distribution, and simulation aspects.
 */
@Component
@RequiredArgsConstructor
public class PopulationInserter {
    private final PopulationService populationService;

    /**
     * Record to store the setup data for population segments, including their names.
     */
    private record Inserter(String name) {
    }

    private final Inserter[] inserts = {
            new Inserter("Pioneers"),
            new Inserter("Colonists"),
            new Inserter("Townsmen"),
            new Inserter("Merchants"),
            new Inserter("Paragons"),
    };

    /**
     * Executes the insertion of predefined population data into the database.
     * Iterates through each record in the predefined list, creating a new population
     * entity for each segment. This method ensures that the application is populated
     * with necessary demographic segments for subsequent operations and simulations.
     */
    public void run() {
        for (Inserter insert : inserts) {
            populationService.post(PopulationDTO.builder()
                    .name(insert.name)
                    .build());
        }
    }
}
