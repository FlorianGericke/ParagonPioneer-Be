package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.PopulationInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
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
     * Private record class used to define the names of population segments to be inserted.
     * Each record represents a distinct population segment, such as pioneers, colonists, etc.
     */
    private record Inserter(String name) {
    }

    /**
     * Predefined list of population segments to be inserted into the database.
     * Each segment represents a distinct demographic group within the application.
     */
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
            try {
            populationService.post(PopulationInput.builder()
                    .name(insert.name)
                    .build());
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create Population " + insert.name);
            }
        }
    }
}
