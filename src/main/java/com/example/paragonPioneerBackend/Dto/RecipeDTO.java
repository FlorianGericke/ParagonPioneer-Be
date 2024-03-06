package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for encapsulating and transferring detailed recipe information within the application.
 * This DTO includes comprehensive details about each ingredient (up to ten inputs) required for the recipe, their respective quantities,
 * and the output product. It's utilized for creating, updating, or displaying recipes through user interfaces or API endpoints.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class RecipeDTO {
    /**
     * Unique identifier of the recipe, used for referencing and managing the recipe within the system.
     */
    @JsonProperty("id")
    private String id;

    // Detailed input and quantity annotations for all ten inputs.

    /**
     * Identifier for the first input good required by the recipe.
     */
    @JsonProperty("input_1")
    private String input1;
    /**
     * Quantity of the first input good required.
     */
    @JsonProperty("quantity_of_input_1")
    private int quantityOfInput1;

    /**
     * Identifier for the second input good.
     */
    @JsonProperty("input_2")
    private String input2;
    /**
     * Quantity of the second input good.
     */
    @JsonProperty("quantity_of_input_2")
    private int quantityOfInput2;

    /**
     * Identifier for the third input good.
     */
    @JsonProperty("input_3")
    private String input3;
    /**
     * Quantity of the third input good.
     */
    @JsonProperty("quantity_of_input_3")
    private int quantityOfInput3;

    /**
     * Identifier for the fourth input good.
     */
    @JsonProperty("input_4")
    private String input4;
    /**
     * Quantity of the fourth input good.
     */
    @JsonProperty("quantity_of_input_4")
    private int quantityOfInput4;

    /**
     * Identifier for the fifth input good.
     */
    @JsonProperty("input_5")
    private String input5;
    /**
     * Quantity of the fifth input good.
     */
    @JsonProperty("quantity_of_input_5")
    private int quantityOfInput5;

    /**
     * Identifier for the sixth input good.
     */
    @JsonProperty("input_6")
    private String input6;
    /**
     * Quantity of the sixth input good.
     */
    @JsonProperty("quantity_of_input_6")
    private int quantityOfInput6;

    /**
     * Identifier for the seventh input good.
     */
    @JsonProperty("input_7")
    private String input7;
    /**
     * Quantity of the seventh input good.
     */
    @JsonProperty("quantity_of_input_7")
    private int quantityOfInput7;

    /**
     * Identifier for the eighth input good.
     */
    @JsonProperty("input_8")
    private String input8;
    /**
     * Quantity of the eighth input good.
     */
    @JsonProperty("quantity_of_input_8")
    private int quantityOfInput8;

    /**
     * Identifier for the ninth input good.
     */
    @JsonProperty("input_9")
    private String input9;
    /**
     * Quantity of the ninth input good.
     */
    @JsonProperty("quantity_of_input_9")
    private int quantityOfInput9;

    /**
     * Identifier for the tenth input good, if applicable.
     */
    @JsonProperty("input_10")
    private String input10;
    /**
     * Quantity of the tenth input good, if applicable.
     */
    @JsonProperty("quantity_of_input_10")
    private int quantityOfInput10;

    /**
     * Identifier of the output product produced by combining the inputs as specified by the recipe.
     * This field links the recipe to its resultant product.
     */
    @JsonProperty("output")
    private String output;
}
