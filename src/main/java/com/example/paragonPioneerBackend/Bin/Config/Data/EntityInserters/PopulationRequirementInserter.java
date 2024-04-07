package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.PopulationRequirementInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.GoodService;
import com.example.paragonPioneerBackend.Service.PopulationRequirementService;
import com.example.paragonPioneerBackend.Service.PopulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Component responsible for seeding the database with initial data representing the relationships
 * between population segments and their requirements. It utilizes the Population_RequirementService
 * to create these associations based on predefined records, setting up essential data for the
 * application to simulate or manage the consumption and production needs of various population segments.
 */
@Component
@RequiredArgsConstructor
public class PopulationRequirementInserter {
    private final PopulationRequirementService populationRequirementService;
    private final GoodService goodService;
    private final PopulationService populationService;

    /**
     * Record to store the setup data for each population requirement, including the population
     * name, the good name, consumption rate, production rate, and whether it is a basic requirement.
     */
    private record Inserter(String populationName, String goodName, float consumption, float produce, boolean isBasic) {
    }

    /**
     * Predefined list of population requirements to be inserted into the database.
     * Each record represents a distinct population segment and its specific requirements.
     */
    private final Inserter[] inserts = {
            new Inserter("Pioneers", "Water", 0, 0, true),
            // todo find out more about the Requirements for all Population Types
    };

    /**
     * Executes the insertion of predefined population requirement data into the database.
     * For each record, it resolves the IDs of populations and goods based on their names and
     * creates associations detailing the consumption and production rates of goods by populations,
     * along with identifying basic needs.
     */
    public void run() {
        for (Inserter insert : inserts) {
            try {
                populationRequirementService.post(PopulationRequirementInput.builder()
                        .good(goodService.findSmthByIdSlugName(insert.goodName).getId().toString())
                        .population(populationService.findSmthByIdSlugName(insert.populationName).getId().toString())
                        .consumption(insert.consumption)
                        .produceRate(insert.produce)
                        .isBasic(insert.isBasic)
                        .build()
                );
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create PopulationRequirement for Population " + insert.populationName + " and Good " + insert.goodName);
            }
        }
    }
}