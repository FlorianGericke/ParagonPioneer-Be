package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Service.BuildingService;
import com.example.paragonPioneerBackend.Service.GoodService;
import com.example.paragonPioneerBackend.Service.RecipeService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * This is a class named Calculator.
 * It is responsible for performing calculations related to production knots.
 */
@Getter
@Setter
public class Calculator {

    // The target production knot for the calculation
    private ProductionKnot target;
    // A list of errors that occurred during the calculation
    private ArrayList<String> errors;
    // Services for interacting with recipes, goods, and buildings
    private final RecipeService recipeService;
    private final GoodService goodService;
    private final BuildingService<?> buildingService;

    /**
     * Constructor for the Calculator class.
     * Initializes the recipe, good, and building services.
     */
    public Calculator(RecipeService recipeService, GoodService goodService, BuildingService<?> buildingService) {
        this.recipeService = recipeService;
        this.goodService = goodService;
        this.buildingService = buildingService;
    }

    /**
     * Performs a calculation based on a given good slug.
     * Returns a CalculationResponse containing the target and any errors that occurred.
     */
    public CalculationResponse calculate(String goodSlug) {
        Good good = goodService.findBySlug(goodSlug);
        ProductionBuilding building = buildingService.getProductionBuildingByRecipeSlug(goodSlug);
        errors = new ArrayList<>();
        this.target = new ProductionKnot(good, building);
        setUp(target, errors);
        return new CalculationResponse(target, errors);
    }

    /**
     * Sets up a production knot.
     * If the good is a map resource, it returns immediately.
     * Otherwise, it finds the recipe for the good and sets up the production building and ingredients.
     */
    private void setUp(ProductionKnot knot, ArrayList<String> errors) {

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

//        ProductionBuilding building = buildingService.getProductionBuildingByRecipeSlug(recipe.getSlug());

        for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
            if (ingredient.good() != null) {
                Building building;
                try {
                    building = buildingService.getProductionBuildingByRecipeSlug(ingredient.good().getSlug());
                } catch (EntityNotFoundException e) {
                    errors.add("No recipe found for " + knot.getGood().getSlug());
                    building = null;
                }
                ProductionKnot ingredientKnot = new ProductionKnot(ingredient.good(), building);
                knot.addIngredient(ingredientKnot);
            }
        }

        for (ProductionKnot ingredient : knot.getIngredients()) {
            setUp(ingredient, errors);
        }
    }

    /**
     * Returns a string representation of the errors.
     */
    public String getErrors() {
        return errors.toString();
    }

    /**
     * Returns a string representation of the Calculator.
     */
    @Override
    public String toString() {
        return "Calculator{" +
                "target=" + target +
                '}';
    }

    /**
     * Returns a formatted string representation of the target.
     */
    public String formatted() {
        return target.formatted(0);
    }
}