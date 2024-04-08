package com.example.paragonPioneerBackend.Bin.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.PopulationInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.PopulationService;
import lombok.RequiredArgsConstructor;
import me.tongfei.progressbar.ProgressBar;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

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
     * Returns the number of data insertion tasks for population segments.
     *
     * @return The number of data insertion tasks.
     */
    public int getInsertsLength() {
        return inserts.length;
    }


    /**
     * Executes the data insertion tasks for population segments.
     * This method is called by the InsertRunner component, providing an entry point
     * for running the inserter components.
     *
     * @param progressBarSupplier A supplier for a progress bar to display the progress of the data insertion tasks.
     */
    public void run(Supplier<ProgressBar> progressBarSupplier) {
        for (Inserter insert : inserts) {
            try {
            populationService.post(PopulationInput.builder()
                    .name(insert.name)
                    .build());
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create Population " + insert.name);
            }finally {
                progressBarSupplier.get();
            }
        }
    }
}
