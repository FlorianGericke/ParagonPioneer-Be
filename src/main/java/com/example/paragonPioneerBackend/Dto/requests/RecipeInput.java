package com.example.paragonPioneerBackend.Dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for encapsulating and transferring detailed recipe information within the application.
 * This DTO includes comprehensive details about each ingredient (up to ten inputs) required for the recipe, their respective quantities,
 * and the output product. It's utilized for creating, updating, or displaying recipes through user interfaces or API endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeInput {
    /**
     * Identifier for the first input good required by the recipe.
     */
    @Builder.Default
    private String input1 = null;
    /**
     * Quantity of the first input good required.
     */
    @Builder.Default
    private Integer quantityOfInput1 = 0;

    /**
     * Identifier for the second input good.
     */
    @Builder.Default
    private String input2 = null;
    /**
     * Quantity of the second input good.
     */
    @Builder.Default
    private Integer quantityOfInput2 = 0;

    /**
     * Identifier for the third input good.
     */
    @Builder.Default
    private String input3 = null;
    /**
     * Quantity of the third input good.
     */
    @Builder.Default
    private Integer quantityOfInput3 = 0;

    /**
     * Identifier for the fourth input good.
     */
    @Builder.Default
    private String input4 = null;
    /**
     * Quantity of the fourth input good.
     */
    @Builder.Default
    private Integer quantityOfInput4 = 0;

    /**
     * Identifier for the fifth input good.
     */
    @Builder.Default
    private String input5 = null;
    /**
     * Quantity of the fifth input good.
     */
    @Builder.Default
    private Integer quantityOfInput5 = 0;

    /**
     * Identifier for the sixth input good.
     */
    @Builder.Default
    private String input6 = null;
    /**
     * Quantity of the sixth input good.
     */
    @Builder.Default
    private Integer quantityOfInput6 = 0;

    /**
     * Identifier for the seventh input good.
     */
    @Builder.Default
    private String input7 = null;
    /**
     * Quantity of the seventh input good.
     */
    @Builder.Default
    private Integer quantityOfInput7 = 0;

    /**
     * Identifier for the eighth input good.
     */
    @Builder.Default
    private String input8 = null;
    /**
     * Quantity of the eighth input good.
     */
    @Builder.Default
    private Integer quantityOfInput8 = 0;

    /**
     * Identifier for the ninth input good.
     */
    @Builder.Default
    private String input9 = null;
    /**
     * Quantity of the ninth input good.
     */
    @Builder.Default
    private Integer quantityOfInput9 = 0;

    /**
     * Identifier for the tenth input good, if applicable.
     */
    @Builder.Default
    private String input10 = null;
    /**
     * Quantity of the tenth input good, if applicable.
     */
    @Builder.Default
    private Integer quantityOfInput10 = 0;

    /**
     * Identifier of the output product produced by combining the inputs as specified by the recipe.
     * This field links the recipe to its resultant product.
     */
    @Builder.Default
    private String output = null;
}