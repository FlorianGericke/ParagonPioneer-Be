package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Setup all data for Buildings
 */
@Component
@RequiredArgsConstructor
public class BuildingInserter {
    private final BuildingRepository repository;
    private final RecipeRepository recipeRepository;

    private record Inserter(String name, String recipe, float productionPerMinute, String remarks) {
    }

    private final Inserter[] inserts = {
            new Inserter("Lumberjack", "Wood", 5f, ""),
            new Inserter("Forester", "", 0, ""),
            new Inserter("Warehouse I", "", 0, ""),
            new Inserter("Well", "Water", 0.01666666667f, ""),
            new Inserter("Kontor I", "", 0, ",Limited to one per island"),
            new Inserter("Fisherman", "Fish", 0.75f, ""),
            new Inserter("Sawmill", "Plank", 5f, ""),
            new Inserter("Potato Field", "Potato Field", 0.01666666667f, ""),
            new Inserter("Potato Farm", "Schnaps", 1f, "")
    };

    /**
     * Run the insertions
     */
    public void run() {
        repository.save(PopulationBuilding.builder().name("Pioneer's Hut").capacity(10).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Colonist's House").capacity(15).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Townsmen's House").capacity(20).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Merchant's Mansion").capacity(25).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Paragon's Residence").capacity(30).remarks("").build());

        for (Inserter insert : inserts) {
            repository.save(ProductionBuilding.builder().name(insert.name).remarks(insert.remarks).recipe(recipeRepository.findByOutputNameIs(insert.recipe).orElse(null)).productionPerMinute(insert.productionPerMinute).build());
        }
    }
}
