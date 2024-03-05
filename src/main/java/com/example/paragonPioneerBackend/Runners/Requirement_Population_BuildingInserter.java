package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Service.BuildingService;
import com.example.paragonPioneerBackend.Service.PopulationService;
import com.example.paragonPioneerBackend.Service.Requirement_Building_PopulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Setup all data for relation require populations for buildings
 */
@Component
@RequiredArgsConstructor
public class Requirement_Population_BuildingInserter {
    private final Requirement_Building_PopulationService requirementBuildingPopulationService;
    private final BuildingService<?> buildingService;
    private final PopulationService populationService;

    private record Inserter(String buildingName, String populationName, int amount) {
    }

    private final Inserter[] inserts = {
            new Inserter("Fisherman", "Pioneers", 10),
            new Inserter("Sawmill", "Pioneers", 50),
            new Inserter("Potato Field", "Pioneers", 50),
            new Inserter("Potato Farm", "Pioneers", 50)
    };

    /**
     * Run the insertions
     */
    public void run() {
        for (Inserter insert : inserts) {
            requirementBuildingPopulationService.post(
                    Requirement_Population_BuildingDTO.builder()
                            .populationId(populationService.findAllByNameContains(insert.populationName).get(0).getId().toString())
                            .buildingId(Objects.requireNonNull(buildingService.findByName(insert.buildingName)).getId().toString())
                            .amount(insert.amount)
                            .build()
            );
        }
    }
}
