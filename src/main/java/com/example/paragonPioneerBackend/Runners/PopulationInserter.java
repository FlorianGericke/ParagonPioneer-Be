package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PopulationInserter {
    private final PopulationRepository repository;

    private record Inserter(String name) {
    }

    Inserter[] inserts = {
            new Inserter("Pioneers"),
            new Inserter("Colonists"),
            new Inserter("Townsmen"),
            new Inserter("Merchants"),
            new Inserter("Paragons"),

    };

    public void run() {
        for (Inserter insert : inserts) {
            repository.save(Population.builder().name(insert.name).build());
        }
    }
}
