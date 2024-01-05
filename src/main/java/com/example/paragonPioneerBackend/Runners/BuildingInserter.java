package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuildingInserter {
    private final BuildingRepository repository;
    private final RecipeRepository recipeRepository;

    private record Inserter(String name, String recipe, float productionPerMinute, String remarks) {
    }

    Inserter[] inserts = {
            new Inserter("Lumberjack", "", 0, ""),
            new Inserter("Forester", "", 0, ""),
            new Inserter("Warehouse I", "", 0, ""),
            new Inserter("Well", "", 0, ""),
            new Inserter("Kontor I", "", 0, ",Limited to one per island"),
            new Inserter("Fisherman", "Fish", 0.75f, ""),
            new Inserter("Sawmill", "", 0, ""),
            new Inserter("Potato Field", "", 0, ""),
            new Inserter("Potato Farm", "", 0, "")
    };

    public void run() {
        repository.save(PopulationBuilding.builder().name("Pioneer's Hut").capacity(10).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Colonist's House").capacity(15).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Townsmen's House").capacity(20).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Merchant's Mansion").capacity(25).remarks("").build());
        repository.save(PopulationBuilding.builder().name("Paragon's Residence").capacity(30).remarks("").build());

        for (Inserter insert : inserts) {
            repository.save(ProductionBuilding.builder().name(insert.name).remarks(insert.remarks).recipe(recipeRepository.findByOutputNameIs(insert.recipe)).productionPerMinute(insert.productionPerMinute).build());
        }
    }
}
