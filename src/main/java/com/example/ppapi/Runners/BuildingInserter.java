package com.example.ppapi.Runners;

import com.example.ppapi.Entity.Building;
import com.example.ppapi.Repository.BuildingRepository;
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
            new Inserter("Pioneer's Hut", ""),
            new Inserter("Well", ""),
            new Inserter("Kontor I", "Limited to one per island"),
            new Inserter("Fisherman", ""),
            new Inserter("Sawmill", ""),
            new Inserter("Potato Field", ""),
            new Inserter("Potato Farm", "")
    };

    public void run() {
        for (Inserter insert : inserts) {
            repository.save(Building.builder().name(insert.name).remarks(insert.remarks).build());
        }
    }
}
