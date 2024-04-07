package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.GoodInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
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
     * A record class that represents an inserter for goods data.
     * This class is used to create instances of goods data that will be inserted into the database.
     * Each instance of this class represents a single good, with properties for the name, remarks, and whether it is a map resource.
     */
    private record Inserter(String name, String remarks, boolean isMapResource) {
        /**
         * A static factory method that creates a new Inserter instance with the specified name and remarks.
         * The isMapResource property is set to false by default.
         *
         * @param name    The name of the good.
         * @param remarks The remarks for the good.
         * @return A new Inserter instance with the specified name and remarks, and isMapResource set to false.
         */
        static Inserter of(String name, String remarks) {
            return new Inserter(name, remarks, false);
        }

        /**
         * A static factory method that creates a new Inserter instance with the specified name, remarks, and isMapResource.
         *
         * @param name          The name of the good.
         * @param remarks       The remarks for the good.
         * @param isMapResource A boolean indicating whether the good is a map resource.
         * @return A new Inserter instance with the specified name, remarks, and isMapResource.
         */
        static Inserter of(String name, String remarks, boolean isMapResource) {
            return new Inserter(name, remarks, isMapResource);
        }
    }

    /**
     * An array of Inserter records that represent the initial goods data to be inserted into the database.
     * Each record in the array represents a single good, with properties for the name, remarks, and whether it is a map resource.
     * The name and remarks are provided as strings, and the isMapResource property is a boolean.
     * The array is populated with a predefined set of goods, each represented by an Inserter record created using the Inserter.of static factory method.
     * This array is used in the run method of the GoodInserter class to populate the database with initial goods data.
     */
    private final Inserter[] inserts = {
            Inserter.of("Land tile", "", true),
            Inserter.of("Water tile", "", true),
            Inserter.of("Mountain tile", "", true),
            Inserter.of("Hop Field", "", true),
            Inserter.of("Horse Field", "", true),
            Inserter.of("Indigo Field", "", true),
            Inserter.of("Linseed Field", "", true),
            Inserter.of("Potato Field", "", true),
            Inserter.of("Sheep Field", "", true),
            Inserter.of("Cotton Field", "", true),
            Inserter.of("Mulberry Trees", "", true),
            Inserter.of("Tobacco Field", "", true),
            Inserter.of("Wheat Field", "", true),
            Inserter.of("Coin", "Global"),
            Inserter.of("Cartography", "Global, used for Discovery"),
            Inserter.of("Favor", "Global, needed for more island slots"),
            Inserter.of("Wood", "Build material"),
            Inserter.of("Fish", ""),
            Inserter.of("Plank", "Build material"),
            Inserter.of("Schnapps", ""),
            Inserter.of("Stone", "Build material"),
            Inserter.of("Linseed", ""),
            Inserter.of("Linen", ""),
            Inserter.of("Bow", ""),
            Inserter.of("Archer", ""),
            Inserter.of("Ropes", ""),
            Inserter.of("Copper Ore", ""),
            Inserter.of("Copper Ingot", ""),
            Inserter.of("Copper Sword", ""),
            Inserter.of("Yarn", ""),
            Inserter.of("Fabric", ""),
            Inserter.of("Wheat", ""),
            Inserter.of("Flour", ""),
            Inserter.of("Bread", ""),
            Inserter.of("Tobacco", ""),
            Inserter.of("Cigar", ""),
            Inserter.of("Sail", ""),
            Inserter.of("Horse", ""),
            Inserter.of("Longbow", ""),
            Inserter.of("Clay", ""),
            Inserter.of("Brick", "Build material"),
            Inserter.of("Clothes", ""),
            Inserter.of("Malt", ""),
            Inserter.of("Hops", ""),
            Inserter.of("Beer", ""),
            Inserter.of("Cattle", ""),
            Inserter.of("Rock Salt", ""),
            Inserter.of("Salt", ""),
            Inserter.of("Meat", ""),
            Inserter.of("Coal", ""),
            Inserter.of("Gold Ore", ""),
            Inserter.of("Gold", ""),
            Inserter.of("Gold Ingot", ""),
            Inserter.of("Gold Jewelry", ""),
            Inserter.of("Linseed Oil", ""),
            Inserter.of("Iron Ore", ""),
            Inserter.of("Iron Ingot", ""),
            Inserter.of("Iron Sword", ""),
            Inserter.of("Militia", ""),
            Inserter.of("Tools", "Build material"),
            Inserter.of("Crossbow", ""),
            Inserter.of("Marble", "Build material"),
            Inserter.of("Silk", ""),
            Inserter.of("Silk Cloth", ""),
            Inserter.of("Dye", ""),
            Inserter.of("Garment", ""),
            Inserter.of("Gemstone", ""),
            Inserter.of("Goblet", ""),
            Inserter.of("Honey", ""),
            Inserter.of("Candle", ""),
            Inserter.of("Candle Holder", ""),
            Inserter.of("Liqueur", ""),
            Inserter.of("Lobster", ""),
            Inserter.of("Feast", ""),
            Inserter.of("Grapes", ""),
            Inserter.of("Barrel", ""),
            Inserter.of("Wine", ""),
            Inserter.of("Windjammer", ""),
            Inserter.of("Book", ""),
            Inserter.of("Coke", ""),
            Inserter.of("Steel Ingot", ""),
            Inserter.of("Armored Horse", ""),
            Inserter.of("Saltpeter", ""),
            Inserter.of("Gunpowder", ""),
            Inserter.of("Cannon", ""),
            Inserter.of("Metal Cuttings", ""),
            Inserter.of("Fireworks", ""),
            Inserter.of("Vineyard", ""),
    };

    /**
     * This method is responsible for running the insertion process of the initial goods data into the database.
     * It iterates over the array of Inserter records, each representing a single good to be inserted.
     * For each record, it creates a new GoodInput object using the GoodInput builder, setting the isMapResource, name, and remarks properties from the record.
     * The GoodInput object is then posted to the GoodService, which handles the actual insertion into the database.
     */
    public void run() {
        for (Inserter insert : inserts) {
            try {
                service.post(GoodInput.builder()
                        .isMapResource(insert.isMapResource)
                        .name(insert.name)
                        .remarks(insert.remarks)
                        .build());
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create Good " + insert.name);
            }
        }

    }
}