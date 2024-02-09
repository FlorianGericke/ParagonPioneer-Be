package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Setup all data for recipes
 */
@Component
@RequiredArgsConstructor
public class RecipeInserter {
    private final RecipeRepository repository;
    private final GoodRepository goodRepository;

    private record Inserter(String i1, int q1, String i2, int q2, String i3, int q3, String i4, int q4, String i5,
                            int q5, String i6, int q6, String i7, int q7, String i8, int q8, String i9, int q9,
                            String i10, int q10, String output) {
    }

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
            new Inserter("Land tile", 1, "Wheat", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Flour"),
            new Inserter("Land tile", 1, "Flour", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Bread"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Horse Field"),
            new Inserter("Land tile", 1, "Horse Field", 20, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Horse"),
            new Inserter("Land tile", 1, "Gold", 1, "Horse", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cavalry"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Tobacco Field"),
            new Inserter("Land tile", 1, "Tobacco", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cigar"),
            new Inserter("Land tile", 1, "Ropes", 1, "Yarn", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Sail"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Clay"),
            new Inserter("Land tile", 1, "Coal", 1, "Clay", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Brick"),
            new Inserter("Land tile", 1, "Linseed", 2, "Wood", 10, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Longbow"),
            new Inserter("Land tile", 1, "Gold", 2, "longbow", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Longbow Archer"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Cotton Field"),
            new Inserter("Land tile", 1, "Fabric", 4, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Clothes"),
            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Hop Field"),
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



/*




            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),
            new Inserter(null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, ""),

  */
    };

    /**
     * Run the insertions
     */
    public void run() {
        for (Inserter insert : inserts) {
            repository.save(Recipe.builder()
                    .output(goodRepository.findByNameIs(insert.output))
                    .input1(goodRepository.findByNameIs(insert.i1))
                    .input2(goodRepository.findByNameIs(insert.i2))
                    .input3(goodRepository.findByNameIs(insert.i3))
                    .input4(goodRepository.findByNameIs(insert.i4))
                    .input5(goodRepository.findByNameIs(insert.i5))
                    .input6(goodRepository.findByNameIs(insert.i6))
                    .input7(goodRepository.findByNameIs(insert.i7))
                    .input8(goodRepository.findByNameIs(insert.i8))
                    .input9(goodRepository.findByNameIs(insert.i9))
                    .input10(goodRepository.findByNameIs(insert.i10))
                    .quantityOfInput1(insert.q1)
                    .quantityOfInput2(insert.q2)
                    .quantityOfInput3(insert.q3)
                    .quantityOfInput4(insert.q4)
                    .quantityOfInput5(insert.q5)
                    .quantityOfInput6(insert.q6)
                    .quantityOfInput7(insert.q7)
                    .quantityOfInput8(insert.q8)
                    .quantityOfInput9(insert.q9)
                    .quantityOfInput10(insert.q10)
                    .build());
        }
    }
}
