package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Service.PopulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Setup all data for populations
 */
@Component
@RequiredArgsConstructor
public class PopulationInserter {
    private final PopulationService populationService;

    private record Inserter(String name) {
    }

    private final Inserter[] inserts = {
            new Inserter("Pioneers"),
            new Inserter("Colonists"),
            new Inserter("Townsmen"),
            new Inserter("Merchants"),
            new Inserter("Paragons"),

    };

    /**
     * Run the insertions
     */
    public void run() {
        for (Inserter insert : inserts) {
            populationService.post(PopulationDTO.builder().name(insert.name).build());
        }
    }
}
