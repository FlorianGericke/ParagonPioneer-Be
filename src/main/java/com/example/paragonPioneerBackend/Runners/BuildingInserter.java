package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Dto.PopulationBuildingDTO;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import com.example.paragonPioneerBackend.Service.BuildingService;
import com.example.paragonPioneerBackend.Service.RecipeService;
import com.example.paragonPioneerBackend.Util.OptionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Setup all data for Buildings
 */
@Component
@RequiredArgsConstructor
public class BuildingInserter {
    private final BuildingService<BuildingDTO> buildingService;
    private final RecipeService recipeService;

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
        buildingService.post(PopulationBuildingDTO.builder().name("Pioneer's Hut").capacity(10).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name("Colonist's House").capacity(15).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name("Townsmen's House").capacity(20).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name("Merchant's Mansion").capacity(25).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name("Paragon's Residence").capacity(30).remarks("").build());

        for (Inserter insert : inserts) {

            buildingService.post(ProductionBuildingDTO.builder()
                    .name(insert.name)
                    .remarks(insert.remarks)
                    .idOfRecipe(OptionalUtil.getIdOrEmpty(recipeService.findByName(insert.recipe)))
                    .productionPerMinute(insert.productionPerMinute)
                    .build());
        }
    }
}
