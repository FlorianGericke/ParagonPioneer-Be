package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Calculator {


    private final ProductionKnot target;


    private final RecipeRepository recipeRepository;
    private final GoodRepository goodRepository;


    public Calculator(RecipeRepository recipeRepository, GoodRepository goodRepository, ProductionKnot target) {
        this.target = target;
        this.recipeRepository = recipeRepository;
        this.goodRepository = goodRepository;
        setUp(this.target);
    }

    public Calculator(RecipeRepository recipeRepository, GoodRepository goodRepository, String goodName, float amount) {
        this(recipeRepository, goodRepository, new ProductionKnot(goodName, amount, recipeRepository.findByOutputNameIs(goodName).get().getProductionBuilding().getName()));
    }

    private void setUp(ProductionKnot target) {


        //todo I need a base case know when to stop the recursive process, throw an exception is not ok !!!
        Good good = goodRepository.findByNameIs(target.getGoodName()).orElseThrow(() -> new EntityNotFoundException(target.getGoodName()));

        if (good.getName().contains("tile")) {
            return;
        }

        Recipe recipe = recipeRepository.findByOutputIs(good).orElseThrow(() -> new EntityNotFoundException(target.getGoodName() + "\n" + this.target.toString()));

        for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
            if (ingredient.good() == null) {
                continue;
            }

            ProductionKnot knot = null;
            if (recipeRepository.findByOutputNameIs(ingredient.good().getName()).isEmpty()) {
                knot = new ProductionKnot(ingredient.good().getName(), ingredient.quantity() * target.getAmount(), "Unknown");

            } else {
                knot = new ProductionKnot(ingredient.good().getName(), ingredient.quantity() * target.getAmount(), recipeRepository.findByOutputNameIs(ingredient.good().getName()).get().getProductionBuilding().getName());
            }
            setUp(knot);
            target.addNeed(knot);
        }
    }

    public String getFormatted() {
        StringBuilder st = new StringBuilder("For the production of ").append(target.getGoodName()).append(" (").append(target.getProductionBuilding()).append(")\n");
        st.append("\t");
        for (ProductionStack stack : target.getNeeds()) {
            ProductionStack cp = (ProductionStack) stack.clone();
            cp.forEach(knot -> st.append(knot.toString(1)));
        }
        return st.toString();
    }
}
