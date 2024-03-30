package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
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
 * The Calculator class is responsible for performing calculations related to production knots.
 * It uses services to interact with recipes, goods, and buildings.
 * It also keeps track of any errors that occur during the calculation.
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
     *
     * @param recipeService The service used for interacting with recipes.
     * @param goodService The service used for interacting with goods.
     * @param buildingService The service used for interacting with buildings.
     */
    public Calculator(RecipeService recipeService, GoodService goodService, BuildingService<?> buildingService) {
        this.recipeService = recipeService;
        this.goodService = goodService;
        this.buildingService = buildingService;
    }

    /**
     * Performs a calculation based on a given good slug.
     * Returns a CalculationResponse containing the target and any errors that occurred.
     *
     * @param goodSlug The slug of the good to calculate.
     * @return A CalculationResponse containing the target and any errors that occurred.
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
     * If a recipe or a building is not found, it adds an error to the list of errors.
     * After setting up the current knot, it recursively sets up all its ingredient knots.
     *
     * @param knot The production knot to set up.
     * @param errors The list of errors to add to if any occur.
     */
    private void setUp(ProductionKnot knot, ArrayList<String> errors) {
        if (knot.getGood().isMapResource()) return;

        try {
            Recipe recipe = recipeService.findBySlug(knot.getGood().getSlug());
            for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
                if (ingredient.good() != null) {
                    Building building = getBuilding(ingredient);
                    knot.addIngredient(new ProductionKnot(ingredient.good(), building));
                }
            }
            knot.getIngredients().forEach(ingredient -> setUp(ingredient, errors));
        } catch (EntityNotFoundException e) {
            errors.add("No recipe found for " + knot.getGood().getSlug());
        }
    }

    /**
     * Retrieves the building that produces a given ingredient.
     * If the building is not found, it returns null.
     *
     * @param ingredient The ingredient to find the building for.
     * @return The building that produces the ingredient, or null if not found.
     */
    private Building getBuilding(Recipe.QuantityOfGood ingredient) {
        try {
            return buildingService.getProductionBuildingByRecipeSlug(ingredient.good().getSlug());
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    /**
     * Returns a string representation of the errors.
     *
     * @return A string representation of the errors.
     */
    public String getErrors() {
        return errors.toString();
    }

    /**
     * Returns a string representation of the Calculator.
     *
     * @return A string representation of the Calculator.
     */
    @Override
    public String toString() {
        return "Calculator{" +
                "target=" + target +
                '}';
    }

    /**
     * Returns a formatted string representation of the target.
     *
     * @return A formatted string representation of the target.
     */
    public String formatted() {
        return target.formatted(0);
    }
}