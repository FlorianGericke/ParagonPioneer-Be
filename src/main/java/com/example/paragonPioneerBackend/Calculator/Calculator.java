package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Service.GoodService;
import com.example.paragonPioneerBackend.Service.RecipeService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {


    private ProductionKnot target;
    private StringBuilder errors;
    private final RecipeService recipeService;
    private final GoodService goodService;


    public Calculator(RecipeService recipeService, GoodService goodService) {
        this.recipeService = recipeService;
        this.goodService = goodService;
    }


    public void setUp(String goodSlug) {
        Good good = goodService.findBySlug(goodSlug);
        errors = new StringBuilder();
        this.target = new ProductionKnot(good);
        setUp(target);
    }


    private void setUp(ProductionKnot knot) {

        if (knot.getGood().isMapResource()) { // base case
            return;
        }
        Recipe recipe;
        try {
            recipe = recipeService.findBySlug(knot.getGood().getSlug());
        } catch (EntityNotFoundException e) {
            errors.append("No recipe found for " + knot.getGood().getSlug()).append(" ").append(knot.getGood().getId()).append("\n");
            return;
        }


        for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
            if (ingredient.good() != null) {
                ProductionKnot ingredientKnot = new ProductionKnot(ingredient.good());
                knot.addIngredient(ingredientKnot);
            }
        }

        for (ProductionKnot ingredient : knot.getIngredients()) {
            setUp(ingredient);
        }
    }

    public String getErrors() {
        return errors.toString();
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "target=" + target +
                '}';
    }

    public String formatted() {
        return target.formatted(0);
    }
}
