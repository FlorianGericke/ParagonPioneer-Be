package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.BuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.PopulationBuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.ProductionBuildingInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A component responsible for seeding the database with initial data for buildings at application startup.
 * Utilizes BuildingService and RecipeService to create population and production buildings, ensuring
 * the application has a baseline set of building data to work with. This class is particularly useful
 * for development and testing environments, providing a consistent starting point for building-related functionalities.
 */
@Component
@RequiredArgsConstructor
public class BuildingInserter {
    private final BuildingService<BuildingInput> buildingService;

    /**
     * A record class that represents an inserter for building data.
     * This class is used to create instances of building data that will be inserted into the database.
     * Each instance of this class represents a single building, with properties for the name, recipe, production per minute, and remarks.
     * The name and recipe are represented by Strings, the production per minute is a float, and the remarks are a String.
     */
    private record Inserter(String name, String recipe, float productionPerMinute, String remarks) {
    }

    /**
     * An array of Inserter records representing the initial building data to be inserted into the database.
     * Each record represents a single building, with properties for the name, recipe, production per minute, and remarks.
     * The array contains records for various buildings, such as lumberjacks, sawmills, farms, and barracks, among others.
     */
    private final Inserter[] inserts = {
            new Inserter("Lumberjack", "Wood", 5f, ""),
            new Inserter("Well", "Water", 0.01667f, ""),
            new Inserter("Fishermans Hut", "Fish", 0.75f, ""),
            new Inserter("Sawmill", "Plank", 5f, ""),
            new Inserter("Potato Field", "Potato Field", 0.01667f, ""),
            new Inserter("Potato Farm", "Schnapps", 1f, ""),
            new Inserter("Tavern", "Community", 0.01667f, ""),
            new Inserter("Linseed Field", "Linseed Field", 0.01667f, ""),
            new Inserter("Linseed Farm", "Linseed", 0.5f, ""),
            new Inserter("Linen Weaver", "Linen", 0.5f, ""),
            new Inserter("Bowyer", "Bow", 0.5f, ""),
            new Inserter("Archery Range", "Archer", 0.1f, ""),
            new Inserter("Ropery", "Ropes", 0.5f, ""),
            new Inserter("Stonecutter", "Stone", 0.14286f, ""),
            new Inserter("Copper Mine", "Copper Ore", 0.25f, ""),
            new Inserter("Copper Smelter", "Copper Ingot", 0.125f, ""),
            new Inserter("Copper Armory", "Copper Sword", 0.125f, ""),
            new Inserter("Barracks", "Footsoldier", 0.1f, ""),
            new Inserter("Sheep Field", "Sheep Field", 0.01667f, ""),
            new Inserter("Sheep Farm", "Yarn", 0.5f, ""),
            new Inserter("Wheat Field", "Wheat Field", 0.01667f, ""),
            new Inserter("Wheat Farm", "Wheat", 0.5f, ""),
            new Inserter("Windmill", "Flour", 0.5f, ""),
            new Inserter("Bakery", "Bread", 0.25f, ""),
            new Inserter("Horse Field", "Horse Field", 0.01667f, ""),
            new Inserter("Horse Breeder", "Horse", 0.01667f, ""),
            new Inserter("Riding Arena", "Cavalry", 0.1f, ""),
            new Inserter("Tobacco Field", "Tobacco Field", 0.01667f, ""),
            new Inserter("Tobacco Farm", "Tobacco", 0.5f, ""),
            new Inserter("Cigar Manufacturer", "Cigar", 0.5f, ""),
            new Inserter("Sailmaker", "Sail", 0.25f, ""),
            new Inserter("Clay Pit", "Clay", 0.5f, ""),
            new Inserter("Brickyard", "Brick", 0.25f, ""),
            new Inserter("Longbowyer", "Longbow", 0.5f, ""),
            new Inserter("Longbow Archer Range", "Longbow Archer", 0.1f, ""),
            new Inserter("Cotton Field", "Cotton Field", 0.01667f, ""),
//            new Inserter("Cotton Plantation","Yarn",1f,""), todo at the moment the backen does not support multiple variants to produce a good
            new Inserter("Tailor", "Clothes", 0.25f, ""),
            new Inserter("Hop Field", "Hop Field", 0.01667f, ""),
            new Inserter("Hop Farm", "Hops", 0.5f, ""),
            new Inserter("Malthouse", "Malt", 0.5f, ""),
            new Inserter("Brewery", "Beer", 0.5f, ""),
            new Inserter("Linseed Pil Press", "Linseed Oil", 0.33333f, ""),
            new Inserter("Medicus", "Medical Care", 0.01667f, ""),
            new Inserter("Iron Mine", "Iron Ore", 0.25f, ""),
            new Inserter("Iron Smelter", "Iron Ingot", 0.125f, ""),
            new Inserter("Toolmaker", "Tools", 0.25f, ""),
            new Inserter("Iron Armory", "Iron Sword", 0.125f, ""),
            new Inserter("Knight Barracks", "Knight", 0.1f, ""),
            new Inserter("Cattle Field", "Cattle Field", 0.01667f, ""),
            new Inserter("Cattle Ranch", "Cattle", 0.25f, ""),
            new Inserter("Rock Salt Mine", "Rock Salt", 0.25f, ""),
            new Inserter("Butchers Shop", "Meat", 1f, ""),
            new Inserter("Gold Mine", "Gold Ore", 0.25f, ""),
            new Inserter("Gold Smelter", "Gold Ingot", 0.125f, ""),
            new Inserter("Goldsmith", "Gold Jewelery", 0.125f, ""),
            new Inserter("Crossbow Maker", "Crossbow", 0.25f, ""),
            new Inserter("Crossbow Shooting Range", "Crossbowman", 0.1f, ""),
            new Inserter("Marble Quarry", "Marble", 0.25f, ""),
            new Inserter("School", "Education", 0.01667f, ""),
            new Inserter("Bathhouse", "Hygiene", 0.01667f, ""),
            new Inserter("Bathhouse providing water", "Water", 0.01667f, ""),
            new Inserter("Mulberry Trees", "Mulberry Trees", 0.01667f, ""),
            new Inserter("Silk Plantation", "Silk", 0.5f, ""),
            new Inserter("Silk Twine Mill", "Silk Cloth", 0.5f, ""),
            new Inserter("Indigo Field", "Indigo Field", 0.01667f, ""),
            new Inserter("Indigo Plantation", "Dye", 0.5f, ""),
            new Inserter("Noble Tailor", "Garment", 0.25f, ""),
            new Inserter("Gemstone Mine", "Gem", 0.33333f, ""),
            new Inserter("Goblet Manufacturer", "Goblet", 0.25f, ""),
            new Inserter("Beehive", "Beehive", 0.01667f, ""),
            new Inserter("Apiary", "Honey", 0.25f, ""),
            new Inserter("Chandler", "Candle", 0.5f, ""),
            new Inserter("Fine Forge", "Candle Holder", 0.75f, ""),
            new Inserter("Cokery", "Coke", 0.25f, ""),
            new Inserter("Steel Furnace", "Steel Ingot", 0.25f, ""),
            new Inserter("Armorsmith", "Armored Horse", 0.25f, ""),
            new Inserter("Cuirassier Academy", "Cuirassier", 0.1f, ""),
            new Inserter("Distillery", "Liqueur", 0.5f, ""),
            new Inserter("Lobsterer", "Lobster", 1.5f, ""),
            new Inserter("Noble Kitchen", "Feast", 1.5f, ""),
            new Inserter("Vineyard", "Vineyard", 0.01667f, ""),
            new Inserter("Winery", "Grape", 0.75f, ""),
            new Inserter("Cooper", "Barrel", 0.75f, ""),
            new Inserter("Winepress", "Wine", 0.75f, ""),
            new Inserter("Paper Mill", "Paper", 0.5f, ""),
            new Inserter("BookBinder", "Book", 0.125f, ""),
            new Inserter("Nitrate Maker", "Salpetre", 0.25f, ""),
            new Inserter("Powder Mill", "Gunpowder", 0.25f, ""),
            new Inserter("Cannon Foundry", "Cannon", 0.125f, ""),
            new Inserter("Cannoneers School", "Cannoneer", 0.1f, ""),
            new Inserter("Planing Mill", "Metal Cuttings", 0.5f, ""),
            new Inserter("Gunsmith", "Fireworks", 0.25f, ""),
            new Inserter("Tiltyard", "Gambling", 0.01667f, ""),
            new Inserter("University", "University", 0.01667f, ""),
    };

    /**
     * This method is responsible for running the insertion process of the initial building data into the database.
     * It first posts a PopulationBuildingInput object representing a "Pioneer's Hut" to the BuildingService.
     * Then, it iterates over the array of Inserter records, each representing a single building to be inserted.
     * For each record, it creates a new ProductionBuildingInput object using the ProductionBuildingInput builder, setting the name, remarks, production per minute, and recipe properties from the record.
     * The ProductionBuildingInput object is then posted to the BuildingService, which handles the actual insertion into the database.
     */
    public void run() {
        buildingService.post(PopulationBuildingInput.builder().name("Pioneer's Hut").capacity(10).remarks("").build());

        for (Inserter insert : inserts) {
            try {
                ProductionBuildingInput dto = ProductionBuildingInput.builder()
                        .name(insert.name)
                        .remarks(insert.remarks)
                        .productionPerMinute(insert.productionPerMinute)
                        .recipe(insert.recipe)
                        .build();
                buildingService.post(dto);
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create Building " + insert.name);
            }
        }
    }
}