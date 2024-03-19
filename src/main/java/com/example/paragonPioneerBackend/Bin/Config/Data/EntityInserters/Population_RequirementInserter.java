package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.Population_RequirementDTO;
import com.example.paragonPioneerBackend.Service.GoodService;
import com.example.paragonPioneerBackend.Service.Population_RequirementService;
import com.example.paragonPioneerBackend.Util.OptionalUtil;
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
public class Population_RequirementInserter {
    private final Population_RequirementService populationRequirementService;
    private final GoodService goodService;

    /**
     * Record to store the setup data for each population requirement, including the population
     * name, the good name, consumption rate, production rate, and whether it is a basic requirement.
     */
    private record Inserter(String populationName, String goodName, float consumption, float produce, boolean isBasic) {
    }

    private final Inserter[] inserts = {
            new Inserter("Pioneers", "Water", 0, 0, true),
            // Additional inserts omitted for brevity
    };

    /**
     * Executes the insertion of predefined population requirement data into the database.
     * For each record, it resolves the IDs of populations and goods based on their names and
     * creates associations detailing the consumption and production rates of goods by populations,
     * along with identifying basic needs.
     */
    public void run() {
        for (Inserter insert : inserts) {
            populationRequirementService.post(
                    Population_RequirementDTO.builder()
                            .goodId(OptionalUtil.getIdOrEmpty(goodService.findByName(insert.goodName)))
                            .populationId(OptionalUtil.getIdOrEmpty(goodService.findByName(insert.populationName))) // Assuming there's a method to find population by name, similar to goodService.findByName
                            .consumption(insert.consumption)
                            .produce(insert.produce)
                            .isBasic(insert.isBasic)
                            .build()
            );
        }
    }
}
