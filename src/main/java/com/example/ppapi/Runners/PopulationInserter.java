package com.example.ppapi.Runners;

import com.example.ppapi.Entity.Population;
import com.example.ppapi.Repository.PopulationRepository;
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
