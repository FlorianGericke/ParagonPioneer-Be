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
            new Inserter("Land tile", 1, "Linseed Field", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Linseed"),
            new Inserter("Land tile", 1, "Linseed", 2, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Linen"),
            new Inserter("Land tile", 1, "Linseed", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Bow"),
            new Inserter("Land tile", 1, "Gold", 0, "Bow", 1, "Militia", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Archer"),

            new Inserter("Land tile", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Potato Field"),

            new Inserter("Land tile", 1, "Linseed", 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Ropes"),
            new Inserter("Land tile", 1, "Plank", 3000, "Sail", 6000, "Steel Ingot", 200, "Gold", 20000, null, 0, null, 0, null, 0, null, 0, null, 0, "Schooner"),
            new Inserter("Land tile", 1, "Plank", 3000, "Sail", 1800, "Steel Ingot", 200, "Gold", 30000, null, 0, null, 0, null, 0, null, 0, null, 0, "Windjammer"),
            new Inserter("Land tile", 1, "Beehive", 8, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, "Honey"),
    };

    /**
     * Run the insertions
     */
    public void run() {
        for (Inserter insert : inserts) {
            repository.save(Recipe.builder()
                    .output(goodRepository.findByNameIs(insert.output).get())
                    .input1(goodRepository.findByNameIs(insert.i1).get())
                    .input2(goodRepository.findByNameIs(insert.i2).get())
                    .input3(goodRepository.findByNameIs(insert.i3).get())
                    .input4(goodRepository.findByNameIs(insert.i4).get())
                    .input5(goodRepository.findByNameIs(insert.i5).get())
                    .input6(goodRepository.findByNameIs(insert.i6).get())
                    .input7(goodRepository.findByNameIs(insert.i7).get())
                    .input8(goodRepository.findByNameIs(insert.i8).get())
                    .input9(goodRepository.findByNameIs(insert.i9).get())
                    .input10(goodRepository.findByNameIs(insert.i10).get())
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
