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
            new Inserter("Well", "Water", 0.01667f, ""),
            new Inserter("Fishermans Hut","Fish",0.75f,""),
            new Inserter("Sawmill","Plank",5f,""),
            new Inserter("Potato Field","Potato Field",0.01667f,""),
            new Inserter("Potato Farm","Schnapps",1f,""),
            new Inserter("Tavern","Community",0.01667f,""),
            new Inserter("Linseed Field","Linseed Field",0.01667f,""),
            new Inserter("Linseed Farm","Linseed",0.5f,""),
            new Inserter("Linen Weaver","Linen",0.5f,""),
            new Inserter("Bowyer","Bow",0.5f,""),
            new Inserter("Archery Range","Archer",0.1f,""),
            new Inserter("Ropery","Ropes",0.5f,""),
            new Inserter("Stonecutter","Stone",0.14286f,""),
            new Inserter("Copper Mine","Copper Ore",0.25f,""),
            new Inserter("Copper Smelter","Copper Ingot",0.125f,""),
            new Inserter("Copper Armory","Copper Sword",0.125f,""),
            new Inserter("Barracks","Footsoldier",0.1f,""),
            new Inserter("Sheep Field","Sheep Field",0.01667f,""),
            new Inserter("Sheep Farm","Yarn",0.5f,""),
            new Inserter("Wheat Field","Wheat Field",0.01667f,""),
            new Inserter("Wheat Farm","Wheat",0.5f,""),
            new Inserter("Windmill","Flour",0.5f,""),
            new Inserter("Bakery","Bread",0.25f,""),
            new Inserter("Horse Field","Horse Field",0.01667f,""),
            new Inserter("Horse Breeder","Horse",0.01667f,""),
            new Inserter("Riding Arena","Cavalry",0.1f,""),
            new Inserter("Tobacco Field","Tobacco Field",0.01667f,""),
            new Inserter("Tobacco Farm","Tobacco",0.5f,""),
            new Inserter("Cigar Manufacturer","Cigar",0.5f,""),
            new Inserter("Sailmaker","Sail",0.25f,""),
            new Inserter("Clay Pit","Clay",0.5f,""),
            new Inserter("Brickyard","Brick",0.25f,""),
            new Inserter("Longbowyer","Longbow",0.5f,""),
            new Inserter("Longbow Archer Range","Longbow Archer",0.1f,""),
            new Inserter("Cotton Field","Cotton Field",0.01667f,""),
            new Inserter("Cotton Plantation","Yarn",1f,""),
            new Inserter("Tailor","Clothes",0.25f,""),
            new Inserter("Hop Field","Hop Field",0.01667f,""),
            new Inserter("Hop Farm","Hops",0.5f,""),
            new Inserter("Malthouse","Malt",0.5f,""),
            new Inserter("Brewery","Beer",0.5f,""),
            new Inserter("Linseed Pil Press","Linseed Oil",0.33333f,""),
            new Inserter("Medicus","Medical Care",0.01667f,""),
            new Inserter("Iron Mine","Iron Ore",0.25f,""),
            new Inserter("Iron Smelter","Iron Ingot",0.125f,""),
            new Inserter("Toolmaker","Tools",0.25f,""),
            new Inserter("Iron Armory","Iron Sword",0.125f,""),
            new Inserter("Knight Barracks","Knight",0.1f,""),





    };
    /*
        new Inserter("","",f,""),
     */

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
            repository.save(ProductionBuilding.builder().name(insert.name).remarks(insert.remarks).recipe(recipeRepository.findByOutputNameIs(insert.recipe)).productionPerMinute(insert.productionPerMinute).build());
        }
    }
}
