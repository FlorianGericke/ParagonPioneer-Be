package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Dto.GoodDTO;
import com.example.paragonPioneerBackend.Service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A component responsible for populating the database with initial goods data.
 * Utilizes the GoodService to create goods entities based on a predefined set of records,
 * ensuring the application has a base set of goods for various operations like crafting or building.
 * This class is particularly useful in development and testing environments, where a consistent
 * dataset is necessary for application functionality testing.
 */
@Component
@RequiredArgsConstructor
public class GoodInserter {
    private final GoodService service;

    /**
     * Record to store the initial setup data for goods, including their name and any remarks.
     */
    private record Inserter(String name, String remarks) {
    }

    private final Inserter[] inserts = {
            new Inserter("Land tile", ""),
            new Inserter("Water tile", ""),
            new Inserter("Mountain tile", ""),
            new Inserter("Hop Field", ""),
            new Inserter("Horse Field", ""),
            new Inserter("Indigo Field", ""),
            new Inserter("Linseed Field", ""),
            new Inserter("Potato Field", ""),
            new Inserter("Sheep Field", ""),
            new Inserter("Cotton Field", ""),
            new Inserter("Mulberry Trees", ""),
            new Inserter("Tobacco Field", ""),
            new Inserter("Wheat Field", ""),
            new Inserter("Coin", "Global"),
            new Inserter("Cartography", "Global, used for Discovery"),
            new Inserter("Favor", "Global, needed for more island slots"),
            new Inserter("Wood", "Build material"),
            new Inserter("Fish", ""),
            new Inserter("Plank", "Build material"),
            new Inserter("Schnapps", ""),
            new Inserter("Stone", "Build material"),
            new Inserter("Linseed", ""),
            new Inserter("Linen", ""),
            new Inserter("Bow", ""),
            new Inserter("Archer", ""),
            new Inserter("Ropes", ""),
            new Inserter("Copper Ore", ""),
            new Inserter("Copper Ingot", ""),
            new Inserter("Copper Sword", ""),
            new Inserter("Yarn", ""),
            new Inserter("Fabric", ""),
            new Inserter("Wheat", ""),
            new Inserter("Flour", ""),
            new Inserter("Bread", ""),
            new Inserter("Tobacco", ""),
            new Inserter("Cigar", ""),
            new Inserter("Sail", ""),
            new Inserter("Horse", ""),
            new Inserter("Longbow", ""),
            new Inserter("Clay", ""),
            new Inserter("Brick", "Build material"),
            new Inserter("Clothes", ""),
            new Inserter("Malt", ""),
            new Inserter("Hops", ""),
            new Inserter("Beer", ""),
            new Inserter("Cattle", ""),
            new Inserter("Rock Salt", ""),
            new Inserter("Salt", ""),
            new Inserter("Meat", ""),
            new Inserter("Coal", ""),
            new Inserter("Gold Ore", ""),
            new Inserter("Gold", ""),
            new Inserter("Gold Ingot", ""),
            new Inserter("Gold Jewelry", ""),
            new Inserter("Linseed Oil", ""),
            new Inserter("Iron Ore", ""),
            new Inserter("Iron Ingot", ""),
            new Inserter("Iron Sword", ""),
            new Inserter("Militia", ""),
            new Inserter("Tools", "Build material"),
            new Inserter("Crossbow", ""),
            new Inserter("Marble", "Build material"),
            new Inserter("Silk", ""),
            new Inserter("Silk Cloth", ""),
            new Inserter("Dye", ""),
            new Inserter("Garment", ""),
            new Inserter("Gemstone", ""),
            new Inserter("Goblet", ""),
            new Inserter("Honey", ""),
            new Inserter("Candle", ""),
            new Inserter("Candle Holder", ""),
            new Inserter("Liqueur", ""),
            new Inserter("Lobster", ""),
            new Inserter("Feast", ""),
            new Inserter("Grapes", ""),
            new Inserter("Barrel", ""),
            new Inserter("Wine", ""),
            new Inserter("Windjammer", ""),
            new Inserter("Book", ""),
            new Inserter("Coke", ""),
            new Inserter("Steel Ingot", ""),
            new Inserter("Armored Horse", ""),
            new Inserter("Saltpeter", ""),
            new Inserter("Gunpowder", ""),
            new Inserter("Cannon", ""),
            new Inserter("Metal Cuttings", ""),
            new Inserter("Fireworks", ""),
            new Inserter("Vineyard", ""),
    };

    /**
     * Executes the insertion of predefined goods data into the database.
     * Iterates through each record in the predefined list and uses the GoodService
     * to create a new Good entity for each, populating the application's database
     * with essential goods data.
     */
    public void run() {
        for (Inserter insert : inserts) {
            service.post(GoodDTO.builder()
                    .name(insert.name)
                    .remarks(insert.remarks)
                    .build());
        }
    }
}