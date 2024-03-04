package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Service.EntityServices.BuildingService;
import com.example.paragonPioneerBackend.Service.EntityServices.PopulationService;
import com.example.paragonPioneerBackend.Service.EntityServices.Requirement_Building_PopulationService;
import com.example.paragonPioneerBackend.Util.OptionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
                            .populationId(OptionalUtil.getIdOrEmpty(populationService.findByName(insert.populationName)))
                            .buildingId(OptionalUtil.getIdOrEmpty(buildingService.findByName(insert.buildingName)))
                            .amount(insert.amount)
                            .build()
            );
        }
    }
}
