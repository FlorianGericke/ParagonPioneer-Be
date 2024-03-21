package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Service.GoodService;
import com.example.paragonPioneerBackend.Service.RecipeService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Calculator {


    private ProductionKnot target;
    private ArrayList<String> errors;
    private final RecipeService recipeService;
    private final GoodService goodService;

    public record CalculationResponse(ProductionKnot target, ArrayList<String> errors) {
    }

    public Calculator(RecipeService recipeService, GoodService goodService) {
        this.recipeService = recipeService;
        this.goodService = goodService;
    }


    public CalculationResponse calculate(String goodSlug) {
        Good good = goodService.findBySlug(goodSlug);
        errors = new ArrayList<>();
        this.target = new ProductionKnot(good);
        setUp(target,errors);
        return new CalculationResponse(target, errors);
    }


    private void setUp(ProductionKnot knot,  ArrayList<String> errors) {

        if (knot.getGood().isMapResource()) { // base case
            return;
        }
        Recipe recipe;
        try {
            recipe = recipeService.findBySlug(knot.getGood().getSlug());
        } catch (EntityNotFoundException e) {
            errors.add("No recipe found for " + knot.getGood().getSlug());
            return;
        }


        for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
            if (ingredient.good() != null) {
                ProductionKnot ingredientKnot = new ProductionKnot(ingredient.good());
                knot.addIngredient(ingredientKnot);
            }
        }

        for (ProductionKnot ingredient : knot.getIngredients()) {
            setUp(ingredient, errors);
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
