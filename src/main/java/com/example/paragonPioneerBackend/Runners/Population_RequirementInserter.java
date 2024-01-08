package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.JoinTables.Population_Requirement;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Repository.Population_RequirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Setup all data for relation population requirements
 */
@Component
@RequiredArgsConstructor
public class Population_RequirementInserter {
    private final Population_RequirementRepository repository;
    private final PopulationRepository populationRepository;
    private final GoodRepository goodRepository;

    private record Inserter(String populationName, String goodName, float consumption, float produce, boolean isBasic) {
    }

    private final Inserter[] inserts = {
            new Inserter("Pioneers", "Water", 0, 0, true),
            new Inserter("Pioneers", "Fish", 1F / 4800, 0, false),
            new Inserter("Pioneers", "Schnapps", 1F / 7200, 0, false),

            new Inserter("Townsmen", "Fish", 1F / 2400, 0, true),
            new Inserter("Townsmen", "Schnapps", 1F / 2400, 0, true),
            new Inserter("Townsmen", "Linen", 0, 0, true),
            new Inserter("Townsmen", "Water", 0, 0, true),
            new Inserter("Townsmen", "Tavern", 0, 0, true),
            new Inserter("Townsmen", "Fabric", 1F / 14400, 1F / 27000, false),
            new Inserter("Townsmen", "Bread", 1F / 15000, 1F / 27000, false),
            new Inserter("Townsmen", "Cigars", 1F / 22500, 1F / 27000, false),
            new Inserter("Townsmen", "School", 0, 1F / 36000, false),

            new Inserter("Merchants", "Fish", 1F / 2400, 0, true),
            new Inserter("Merchants", "Schnapps", 1F / 2400, 0, true),
            new Inserter("Merchants", "Cigars", 1F / 22500, 0, true),
            new Inserter("Merchants", "Bread", 1F / 15000, 0, true),
            new Inserter("Merchants", "Water", 0, 0, true),
            new Inserter("Merchants", "Tavern", 0, 0, true),
            new Inserter("Merchants", "School", 0, 0, true),
            new Inserter("Merchants", "Clothes", 1F / 30000, 1F / 9000, false),
            new Inserter("Merchants", "Beer", 1F / 15000, 1F / 9000, false),
            new Inserter("Merchants", "Meat", 1F / 7500, 1F / 9000, false),
            new Inserter("Merchants", "Gold Jewelry", 1F / 45000, 1F / 9000, false),
            new Inserter("Merchants", "Medicus", 0, 1F / 18000, false),
            new Inserter("Merchants", "Bath House", 0, 1F / 18000, false),

            new Inserter("Paragons", "Cigars", 1F / 22500, 0, true),
            new Inserter("Paragons", "Clothes", 1F / 30000, 0, true),
            new Inserter("Paragons", "Beer", 1F / 15000, 0, true),
            new Inserter("Paragons", "Meat", 1F / 7500, 0, true),
            new Inserter("Paragons", "Water", 0, 0, true),
            new Inserter("Paragons", "Tavern", 0, 0, true),
            new Inserter("Paragons", "School", 0, 0, true),
            new Inserter("Paragons", "Medicus", 0, 0, true),
            new Inserter("Paragons", "Bath House", 0, 0, true),
            new Inserter("Paragons", "Garment", 1F / 15300, 0, false),
            new Inserter("Paragons", "Goblet", 1F / 30600, 0, false),
            new Inserter("Paragons", "Candle Holder", 1F / 20400, 0, false),
            new Inserter("Paragons", "Feast", 1F / 10200, 0, false),
            new Inserter("Paragons", "Wine", 1F / 13600, 0, false),
            new Inserter("Paragons", "Concert Hall", 0, 0, false),
            new Inserter("Paragons", "Tiltyard", 0, 0, false),
            new Inserter("Paragons", "University", 0, 0, false),
    };

    /**
     * Run the insertions
     */
    public void run() {
        for (Inserter insert : inserts) {
            repository.save(
                    Population_Requirement.builder()
                            .good(goodRepository.findByNameIs(insert.goodName))
                            .population(populationRepository.findByNameIs(insert.populationName))
                            .consumption(insert.consumption)
                            .produce(insert.produce)
                            .isBasic(insert.isBasic)
                            .build()
            );
        }
    }
}
