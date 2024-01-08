package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class RecipeDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("input_1")
    private String input1;
    @JsonProperty("quantity_of_input_1")
    private int quantityOfInput1;

    @JsonProperty("input_2")
    private String input2;
    @JsonProperty("quantity_of_input_2")
    private int quantityOfInput2;

    @JsonProperty("input_3")
    private String input3;
    @JsonProperty("quantity_of_input_3")
    private int quantityOfInput3;

    @JsonProperty("input_4")
    private String input4;
    @JsonProperty("quantity_of_input_4")
    private int quantityOfInput4;

    @JsonProperty("input_5")
    private String input5;
    @JsonProperty("quantity_of_input_5")
    private int quantityOfInput5;

    @JsonProperty("input_6")
    private String input6;
    @JsonProperty("quantity_of_input_6")
    private int quantityOfInput6;

    @JsonProperty("input_7")
    private String input7;
    @JsonProperty("quantity_of_input_7")
    private int quantityOfInput7;

    @JsonProperty("input_8")
    private String input8;
    @JsonProperty("quantity_of_input_8")
    private int quantityOfInput8;

    @JsonProperty("input_9")
    private String input9;
    @JsonProperty("quantity_of_input_9")
    private int quantityOfInput9;

    @JsonProperty("input_10")
    private String input10;
    @JsonProperty("quantity_of_input_10")
    private int quantityOfInput10;

    @JsonProperty("output")
    private String output;
}