package com.example.paragonPioneerBackend.Dto;

import com.example.paragonPioneerBackend.Calculator.CalculationResponse;
import com.example.paragonPioneerBackend.Calculator.ProductionKnot;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * This is a Data Transfer Object (DTO) class named CalculationOutputDTO.
 * It is used to transfer data between processes or components.
 * It contains a nested static class named ProductionChain and methods to create a CalculationOutputDTO from a CalculationResponse.
 */
@Data
public class CalculationOutputDTO {
    /**
     * This is a static nested class named ProductionChain.
     * It represents a chain of production in the calculation output.
     */
    @Data
    @NoArgsConstructor
    private static class ProductionChain {
        // The slug of the good
        @JsonProperty("goodSlug")
        String goodSlug;
        // The name of the good
        @JsonProperty("goodName")
        String goodName;
        // The id of the good
        @JsonProperty("goodId")
        String goodId;
        // The slug of the building
        @JsonProperty("buildingSlug")
        String buildingSlug;
        // The name of the building
        @JsonProperty("buildingName")
        String buildingName;
        // The id of the building
        @JsonProperty("buildingId")
        String buildingIdl;
        // The list of ingredients in the production chain
        ArrayList<ProductionChain> ingredients = new ArrayList<>();
    }

    // The recipe in the calculation output
    @JsonProperty("recipe")
    private ProductionChain recipe;

    // The list of errors in the calculation output
    @JsonProperty("errors")
    private ArrayList<String> errors;

    /**
     * Creates a CalculationOutputDTO from a CalculationResponse.
     * It initializes a new CalculationOutputDTO and a new ProductionChain, then calls the createProductionChain method to fill the ProductionChain.
     * Finally, it sets the errors and the recipe in the CalculationOutputDTO and returns it.
     */
    public static CalculationOutputDTO createFromEntity(CalculationResponse calculation) {
        CalculationOutputDTO response = new CalculationOutputDTO();
        ProductionChain recipe = new ProductionChain();
        createProductionChain(calculation.target(), recipe);

        response.setErrors(calculation.errors());
        response.setRecipe(recipe);
        return response;
    }

    /**
     * Creates a production chain from a ProductionKnot.
     * It initializes a new ProductionChain and sets the good and building information.
     * Then, it iterates through the ingredients of the ProductionKnot and calls itself recursively to create the ingredients.
     * Finally, it adds the ingredients to the parent ProductionChain.
     */
    private static void createProductionChain(ProductionKnot knot, ProductionChain parent) {
        parent.setGoodSlug(knot.getGood().getSlug());
        parent.setGoodName(knot.getGood().getName());
        parent.setGoodId(knot.getGood().getId().toString());

        parent.setBuildingSlug(knot.getManufacturer() == null ? null : knot.getManufacturer().getSlug());
        parent.setBuildingName(knot.getManufacturer() == null ? null : knot.getManufacturer().getName());
        parent.setBuildingIdl(knot.getManufacturer() == null ? null : knot.getManufacturer().getId().toString());

        if (!knot.getIngredients().isEmpty()) {
            for (ProductionKnot ingredient : knot.getIngredients()) {
                ProductionChain child = new ProductionChain();
                createProductionChain(ingredient, child);
                parent.getIngredients().add(child);
            }
        }
    }
}