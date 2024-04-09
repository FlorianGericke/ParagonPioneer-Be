package com.example.paragonPioneerBackend.Bin.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.RequirementPopulationBuildingInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.BuildingService;
import com.example.paragonPioneerBackend.Service.PopulationService;
import com.example.paragonPioneerBackend.Service.RequirementBuildingPopulationService;
import lombok.RequiredArgsConstructor;
import me.tongfei.progressbar.ProgressBar;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * Component for seeding the database with initial data on the population requirements for buildings.
 * It uses Requirement_Building_PopulationService to create relationships that specify the minimum
 * population needed for each building, leveraging BuildingService and PopulationService to link
 * buildings with their respective population segments. This process is crucial for establishing
 * a realistic and interactive environment where population dynamics directly influence building
 * functionality and operational capabilities.
 */
@Component
@RequiredArgsConstructor
public class RequirementPopulationBuildingInserter {
    private final RequirementBuildingPopulationService requirementBuildingPopulationService;
    private final BuildingService<?> buildingService;
    private final PopulationService populationService;

    /**
     * Record to store the initial setup data for building-population requirements,
     * including the building name, the required population segment name, and the amount needed.
     */
    private record Inserter(String buildingName, String populationName, int amount) {
    }

    /**
     * An array of Inserter records that represent the initial setup data for building-population requirements.
     * Each record represents a single building-population requirement, with properties for the building name, the required population segment name, and the amount needed.
     * The building name and population segment name are represented by Strings, and the amount needed is an integer.
     * This array is used to seed the database with initial data on the population requirements for buildings.
     */
    private final Inserter[] inserts = {
            new Inserter("Fisherman", "Pioneers", 10),
            new Inserter("Sawmill", "Pioneers", 50),
            // todo add more building-population requirements
    };

    /**
     * Returns the number of data insertion tasks for building-population requirements.
     *
     * @return The number of data insertion tasks.
     */
    public int getInsertsLength() {
        return inserts.length;
    }

    /**
     * Executes the data insertion tasks for building-population requirements.
     * This method is called by the InsertRunner component, providing an entry point
     * for running the inserter components.
     *
     * @param progressBarSupplier A supplier for a progress bar to display the progress of the data insertion tasks.
     */
    public void run(Supplier<ProgressBar> progressBarSupplier) {
        for (Inserter insert : inserts) {
            try {
                RequirementPopulationBuildingInput dto = RequirementPopulationBuildingInput.builder()
                        .population(populationService.findSmthByIdSlugName(insert.populationName).getId().toString())
                        .building(buildingService.findSmthByIdSlugName(insert.buildingName).getId().toString())
                        .amount(insert.amount)
                        .build();
                requirementBuildingPopulationService.post(dto);
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create Building Population for Building: " + insert.buildingName + " and Population: " + insert.populationName);
            }finally {
                progressBarSupplier.get();
            }
        }
    }
}