package com.example.paragonPioneerBackend.Dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Data Transfer Object (DTO) class for transferring building data between the application's layers,
 * such as from the service layer to the presentation layer or through RESTful APIs.
 * It encapsulates the basic attributes of a building that are commonly required for display or processing
 * in client-server communication.
 */
@Data
@SuperBuilder
@NoArgsConstructor
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
}
