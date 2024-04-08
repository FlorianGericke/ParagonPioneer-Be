package com.example.paragonPioneerBackend.Calculator;

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
     * @param recipeService   The service used for interacting with recipes.
     * @param goodService     The service used for interacting with goods.
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
        errors = new ArrayList<>();
        Good good = goodService.findBySlug(goodSlug);
        ProductionBuilding building = getBuilding(goodSlug);
        this.target = new ProductionKnot(good, building);
        var depth = setUp(target, errors, 0);
        return new CalculationResponse(target, errors);
    }

    /**
     * Sets up the production knot by adding ingredients recursively.
     * Returns the maximum depth of the production knot.
     *
     * @param knot   The production knot to set up.
     * @param errors The list of errors to add to.
     * @param depth  The current depth of the production knot.
     * @return The maximum depth of the production knot.
     */
    private int setUp(ProductionKnot knot, ArrayList<String> errors, int depth) {
        if (knot.getGood().isMapResource()) return depth;

        int maxDepth = depth;
        try {
            Recipe recipe = recipeService.findBySlug(knot.getGood().getSlug());
            for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
                if (ingredient.good() != null) {
                    ProductionBuilding building = getBuilding(ingredient);
                    knot.addIngredient(new ProductionKnot(ingredient.good(), building));
                }
            }
            for (ProductionKnot ingredient : knot.getIngredients()) {
                int ingredientDepth = setUp(ingredient, errors, depth + 1);
                if (ingredientDepth > maxDepth) {
                    maxDepth = ingredientDepth;
                }
            }
        } catch (EntityNotFoundException e) {
            errors.add("No recipe found for " + knot.getGood().getSlug());
        }
        return maxDepth;
    }

    /**
     * Retrieves the building that produces a given ingredient.
     * If the building is not found, it returns null.
     *
     * @param ingredient The ingredient to find the building for.
     * @return The building that produces the ingredient, or null if not found.
     */
    private ProductionBuilding getBuilding(Recipe.QuantityOfGood ingredient) {
        // Call the overloaded getBuilding method with the slug of the good as the argument
        return getBuilding(ingredient.good().getSlug());
    }

    /**
     * Retrieves the building that produces a good with a given slug.
     * If the building is not found, it adds an error message to the errors list and returns null.
     *
     * @param ingredientSlug The slug of the good to find the building for.
     * @return The building that produces the good, or null if not found.
     */
    private ProductionBuilding getBuilding(String ingredientSlug) {
        try {
            // Try to get the production building by the recipe slug
            return buildingService.getProductionBuildingByRecipeSlug(ingredientSlug);
        } catch (EntityNotFoundException e) {
            // If the building is not found, add an error message to the errors list
            errors.add("No ProductionBuilding found for " + ingredientSlug);
            // Return null as the building was not found
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