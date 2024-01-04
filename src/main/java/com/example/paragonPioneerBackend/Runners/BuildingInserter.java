package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuildingInserter{
    private final BuildingRepository repository;
    private record Inserter(String name, String remarks) {
    }

    Inserter[] inserts = {
            new Inserter("Lumberjack", ""),
            new Inserter("Forester", ""),
            new Inserter("Warehouse I", ""),
            new Inserter("Well", ""),
            new Inserter("Kontor I", "Limited to one per island"),
            new Inserter("Fisherman", ""),
            new Inserter("Sawmill", ""),
            new Inserter("Potato Field", ""),
            new Inserter("Potato Farm", "")
    };

    public void run() {
        repository.save(PopulationBuilding.builder().name("Pioneer's Hut").capacity(10).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Colonist's House").capacity(15).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Townsmen's House").capacity(20).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Merchant's Mansion").capacity(25).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Paragon's Residence").capacity(30).remarks("").build());

        for (Inserter insert : inserts) {
            repository.save(ProductionBuilding.builder().name(insert.name).remarks(insert.remarks).build());
        }
    }
}
