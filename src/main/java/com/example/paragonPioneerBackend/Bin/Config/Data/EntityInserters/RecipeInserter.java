package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.RecipeInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.GoodService;
import com.example.paragonPioneerBackend.Service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A component designed to seed the database with initial recipe data upon application startup.
 * It uses RecipeService to create recipe entities and GoodService to resolve the necessary goods,
 * ensuring the application is populated with a comprehensive set of crafting or production recipes.
 * This process establishes the foundation for game mechanics involving resource management, crafting,
 * and economic simulation.
 */
@Component
@RequiredArgsConstructor
public class RecipeInserter {
    private final RecipeService recipeService;
    private final GoodService goodService;

    /**
     * A record class that represents an inserter for recipe data.
     * This class is used to create instances of recipe data that will be inserted into the database.
     * Each instance of this class represents a single recipe, with properties for the input goods, their quantities, and the output good.
     * The input goods are represented by Strings (i1 to i10) and their corresponding quantities by integers (q1 to q10).
     * The output good is also represented by a String.
     */
    private record Inserter(String i1, int q1, String i2, int q2, String i3, int q3, String i4, int q4, String i5,
                            int q5, String i6, int q6, String i7, int q7, String i8, int q8, String i9, int q9,
                            String i10, int q10, String output) {
    }

    /**
     * This class represents a list of Inserter objects. Each Inserter object represents a production process in a game.
     * Each process takes place on a specific type of tile, requires a certain amount of time, and may require up to 9 different input goods.
     * Each input good has a corresponding quantity. The process produces a single type of output good.
     * <p>
     * The Inserter constructor takes the following parameters:
     * - tileType: The type of tile on which the process takes place.
     * - time: The time required for the process to complete.
     * - inputGood1 to inputGood9: The goods required as input for the process. If a process requires fewer than 9 goods, the remaining parameters should be null.
     * - quantity1 to quantity9: The quantity of each input good required for the process. If a process requires fewer than 9 goods, the remaining parameters should be 0.
     * - outputGood: The good produced by the process.
     */
    private final Inserter[] inserts = {
            new Inserter("Land tile", 7, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Wood"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Water"),
            new Inserter("Land tile", 1, "Water tile", 4, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Fish"),
            new Inserter("Land tile", 1, "Wood", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Plank"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Potato Field"),
            new Inserter("Land tile", 1, "Potato Field", 4, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Schnapps"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Community"),
            new Inserter("Land tile", 1, "Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Linseed Field"),
            new Inserter("Land tile", 1, "Linseed Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Linseed"),
            new Inserter("Land tile", 1, "Linseed", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Linen"),
            new Inserter("Land tile", 1, "Linseed", 1, "Wood", 5, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Bow"),
            new Inserter("Land tile", 1, "Gold", 0, "Bow", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Archer"),
            new Inserter("Land tile", 1, "Linseed", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Ropes"),
            new Inserter("Land tile", 1, "Mountain tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Stone"),
            new Inserter("Mountain tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Copper Ore"),
            new Inserter("Land tile", 1, "Copper Ore", 1, "Wood", 10, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Copper Ingot"),
            new Inserter("Land tile", 1, "Copper Ingot", 1, "Wood", 10, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Copper Sword"),
            new Inserter("Land tile", 1, "Gold", 1, "Copper Sword", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Footsoldier"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Sheep Field"),
            new Inserter("Land tile", 1, "Sheep Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Yarn"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Wheat Field"),
            new Inserter("Land tile", 1, "Wheat Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Wheat"),
            new Inserter("Land tile", 1, "Wheat", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Flour"),
            new Inserter("Land tile", 1, "Flour", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Bread"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Horse Field"),
            new Inserter("Land tile", 1, "Horse Field", 20, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Horse"),
            new Inserter("Land tile", 1, "Gold", 1, "Horse", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cavalry"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Tobacco Field"),
            new Inserter("Land tile", 1, "Tobacco Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Tobacco"),
            new Inserter("Land tile", 1, "Tobacco", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cigar"),
            new Inserter("Land tile", 1, "Ropes", 1, "Yarn", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Sail"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Clay"),
            new Inserter("Land tile", 1, "Coal", 1, "Clay", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Brick"),
            new Inserter("Land tile", 1, "Linseed", 2, "Wood", 10, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Longbow"),
            new Inserter("Land tile", 1, "Gold", 2, "longbow", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Longbow Archer"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cotton Field"),
//            new Inserter("Land tile", 1, "Cotton Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Yarn"), todo : Ath the moment the backend does not support multiple types of recipes for one good
            new Inserter("Land tile", 1, "Fabric", 4, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Clothes"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Hop Field"),
            new Inserter("Land tile", 1, "Hop Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Hops"),
            new Inserter("Land tile", 1, "Wheat", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Malt"),
            new Inserter("Land tile", 1, "Hops", 3, "Malt", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Beer"),
            new Inserter("Land tile", 1, "Linseed", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Linseed Oil"),
            new Inserter("Land tile", 1, "Linseed Oil", 60, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Medical Care"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Iron Ore"),
            new Inserter("Land tile", 1, "Coal", 1, "Iron Ore", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Iron Ingot"),
            new Inserter("Land tile", 1, "Coal", 1, "Iron Ingot", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Tools"),
            new Inserter("Land tile", 1, "Coal", 1, "Iron Ingot", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Iron Sword"),
            new Inserter("Land tile", 1, "Gold", 4, "Iron Sword", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Knight"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cattle Field"),
            new Inserter("Land tile", 1, "Cattle Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cattle"),
            new Inserter("Mountain tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Rock Salt"),
            new Inserter("Land tile", 1, "Salt", 1, "Cattle", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Meat"),
            new Inserter("Mountain tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Gold Ore"),
            new Inserter("Land tile", 1, "Coal", 1, "Gold Ore", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Gold Ingot"),
            new Inserter("Land tile", 1, "Coal", 1, "Gold Ingot", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Gold Jewelry"),
            new Inserter("Land tile", 1, "Linseed", 2, "Iron Ingot", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Crossbow"),
            new Inserter("Land tile", 1, "Gold", 4, "Crossbow", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Crossbowman"),
            new Inserter("Land tile", 1, "Mountain tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Marble"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Education"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Hygiene"),
//            new Inserter("Land tile", 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Water"),  todo: multiple recipe variant are currently not supported by the Backend, this feature will be implement later
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Mulberry Tree"),
            new Inserter("Land tile", 1, "Mulberry Tree", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Silk"),
            new Inserter("Land tile", 1, "Silk", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Silk Cloth"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Indigo Field"),
            new Inserter("Land tile", 1, "Indigo Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Dye"),
            new Inserter("Land tile", 1, "Silk Cloth", 1, "Dye", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Garment"),
            new Inserter("Mountain tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Gem"),
            new Inserter("Land tile", 1, "Gold Ingot", 1, "Gem", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Goblet"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Beehive"),
            new Inserter("Land tile", 1, "Beehive", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Honey"),
            new Inserter("Land tile", 1, "Linseed", 1, "Honey", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Candle"),
            new Inserter("Land tile", 1, "Candle", 3, "Copper Ingot", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Candle Holder"),
            new Inserter("Land tile", 1, "Coal", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Coke"),
            new Inserter("Land tile", 1, "Iron Ingot", 1, "Coke", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Steel Ingot"),
            new Inserter("Land tile", 1, "Horse", 1, "Steel Ingot", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Armored Horse"),
            new Inserter("Land tile", 1, "Gold", 5, "Armored Horse", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cuirassier"),
            new Inserter("Land tile", 1, "Schnapps", 2, "Honey", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Liqueur"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Lobster"),
            new Inserter("Land tile", 1, "Liqueur", 1, "Lobster", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Feast"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Vineyard"),
            new Inserter("Land tile", 1, "Vineyard", 12, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Grape"),
            new Inserter("Land tile", 1, "Iron Ingot", 1, "Plank", 16, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Barrel"),
            new Inserter("Land tile", 1, "Grape", 4, "Barrel", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Wine"),
            new Inserter("Land tile", 1, "Wood", 16, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Paper"),
            new Inserter("Land tile", 1, "Paper", 4, "Dye", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Book"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Salpetre"),
            new Inserter("Land tile", 1, "Coal", 1, "Salpetre", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Gunpowder"),
            new Inserter("Land tile", 1, "Steel Ingot", 1, "Gunpowder", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cannon"),
            new Inserter("Land tile", 1, "Gold", 5, "Cannon", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cannoneer"),
            new Inserter("Land tile", 1, "Iron Ingot", 1, "Copper Ingot", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Metal Cuttings"),
            new Inserter("Land tile", 1, "Gunpowder", 2, "Metal Cuttings", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Fireworks"),
            new Inserter("Land tile", 1, "Horse", 20, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Gambling"),
            new Inserter("Land tile", 1, "Book", 15, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "University"),
    };

    /**
     * This method is responsible for running the insertion process of the initial recipe data into the database.
     * It iterates over the array of Inserter records, each representing a single recipe to be inserted.
     * For each record, it creates a new RecipeInput object using the RecipeInput builder, setting the properties for the input goods and their quantities, and the output good from the record.
     * The RecipeInput object is then posted to the RecipeService, which handles the actual insertion into the database.
     * If a recipe for a good is not found, it catches the EntityNotFoundException and prints a message to the console.
     */
    public void run() {
        for (Inserter insert : inserts) {
            try {
                recipeService.post(RecipeInput.builder()
                        .input1(getIdOrNull(insert.i1))
                        .quantityOfInput1(insert.q1)
                        .input2(getIdOrNull(insert.i2))
                        .quantityOfInput2(insert.q2)
                        .input3(getIdOrNull(insert.i3))
                        .quantityOfInput3(insert.q3)
                        .input4(getIdOrNull(insert.i4))
                        .quantityOfInput4(insert.q4)
                        .input5(getIdOrNull(insert.i5))
                        .quantityOfInput5(insert.q5)
                        .input6(getIdOrNull(insert.i6))
                        .quantityOfInput6(insert.q6)
                        .input7(getIdOrNull(insert.i7))
                        .quantityOfInput7(insert.q7)
                        .input8(getIdOrNull(insert.i8))
                        .quantityOfInput8(insert.q8)
                        .input9(getIdOrNull(insert.i9))
                        .quantityOfInput9(insert.q9)
                        .input10(getIdOrNull(insert.i10))
                        .quantityOfInput10(insert.q10)
                        .output(getIdOrNull(insert.output))
                        .build());
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create Recipe for good: " + insert.output);
            }
        }
    }

    /**
     * Retrieves the ID of a good by its name, returning null if the good is not found.
     *
     * @param name The name of the good.
     * @return The ID of the good as a String, or null if not found.
     */
    private String getIdOrNull(String name) {
        try {
            return goodService.findSmthByIdSlugName(name).getId().toString();
        } catch (Exception e) {
            return null;
        }
    }
}