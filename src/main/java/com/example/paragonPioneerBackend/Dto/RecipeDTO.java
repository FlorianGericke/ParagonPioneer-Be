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
    private UUID input1;
    @JsonProperty("input_1")
    private String input1Name;
    @JsonProperty("quantity_of_input_1")
    private int quantityOfInput1;

    @JsonProperty("input_2")
    private UUID input2;
    @JsonProperty("input_2")
    private String input2Name;
    @JsonProperty("quantity_of_input_2")
    private int quantityOfInput2;

    @JsonProperty("input_3")
    private UUID input3;
    @JsonProperty("input_3")
    private String input3Name;
    @JsonProperty("quantity_of_input_3")
    private int quantityOfInput3;

    @JsonProperty("input_4")
    private UUID input4;
    @JsonProperty("input_4")
    private String input4Name;
    @JsonProperty("quantity_of_input_4")
    private int quantityOfInput4;

    @JsonProperty("input_5")
    private UUID input5;
    @JsonProperty("input_5")
    private String input5Name;
    @JsonProperty("quantity_of_input_5")
    private int quantityOfInput5;

    @JsonProperty("input_6")
    private UUID input6;
    @JsonProperty("input_6")
    private String input6Name;
    @JsonProperty("quantity_of_input_6")
    private int quantityOfInput6;

    @JsonProperty("input_7")
    private UUID input7;
    @JsonProperty("input_7")
    private String input7Name;
    @JsonProperty("quantity_of_input_7")
    private int quantityOfInput7;

    @JsonProperty("input_8")
    private UUID input8;
    @JsonProperty("input_8")
    private String input8Name;
    @JsonProperty("quantity_of_input_8")
    private int quantityOfInput8;

    @JsonProperty("input_9")
    private UUID input9;
    @JsonProperty("input_9")
    private String input9Name;
    @JsonProperty("quantity_of_input_9")
    private int quantityOfInput9;

    @JsonProperty("input_10")
    private UUID input10;
    @JsonProperty("input_10")
    private String input10Name;
    @JsonProperty("quantity_of_input_10")
    private int quantityOfInput10;

    @JsonProperty("output")
    private UUID output;
    @JsonProperty("output")
    private String outputName;
}