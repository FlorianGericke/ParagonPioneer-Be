package com.example.paragonPioneerBackend.Dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Map;

/**
 * Data Transfer Object (DTO) class for transferring building data between the application's layers,
 * such as from the service layer to the presentation layer or through RESTful APIs.
 * It encapsulates the basic attributes of a building that are commonly required for display or processing
 * in client-server communication.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BuildingInput {
    /**
     * Name of the building. Provides a human-readable identifier for the building.
     */
    @Builder.Default
    @JsonProperty("name")
    private String name = null;

    /**
     * Additional remarks about the building. Can include any notes or additional information
     * relevant to the building.
     */
    @Builder.Default
    @JsonProperty("remarks")
    private String remarks = null;

    /**
     * The costs associated with the building.
     * This is a list of maps, where each map represents a cost item.
     * Each cost item has two properties: "good" and "amount".
     * The "good" property can be an IRI, Slug, UUID, or Name.
     * The "amount" property is a string representing the amount of the good required.
     * This property is serialized/deserialized with the JSON property name "Costs".
     */
    @Builder.Default
    @JsonProperty("Costs")
    @SchemaProperties({
            @SchemaProperty(name = "good", schema = @Schema(type = "IRI, Slug, UUID, or Name")),
            @SchemaProperty(name = "amount", schema = @Schema(type = "string"))
    })
    @Schema(example = """
            [
                {
                    "good": "string",
                    "amount": "string"
                }
            ]""")
    private ArrayList<Map<String, String>> costs = null;
}