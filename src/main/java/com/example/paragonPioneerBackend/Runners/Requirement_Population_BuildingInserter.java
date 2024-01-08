package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Requirement_Population_BuildingInserter {
    private final Requirement_Population_BuildingRepository repository;
    private final PopulationBuildingRepository buildingRepository;
    private final PopulationRepository populationRepository;

    private record Inserter(String buildingName, String populationName, int amount) {
    }

    Inserter[] inserts = {
            new Inserter("Fisherman", "Pioneers", 10),
            new Inserter("Sawmill", "Pioneers", 50),
            new Inserter("Potato Field", "Pioneers", 50),
            new Inserter("Potato Farm", "Pioneers", 50)
    };

    public void run() {
        for (Inserter insert : inserts) {
            repository.save(
                    Requirement_Population_Building.builder()
                            .population(populationRepository.findByNameIs(insert.populationName))
                            .building(buildingRepository.findByNameIs(insert.buildingName))
                            .amount(insert.amount)
                            .build()
            );
        }
    }
}
