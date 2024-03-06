package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Data Transfer Object (DTO) class for transferring building data between the application's layers,
 * such as from the service layer to the presentation layer or through RESTful APIs.
 * It encapsulates the basic attributes of a building that are commonly required for display or processing
 * in client-server communication.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BuildingDTO {

    /**
     * Unique identifier of the building. Used to uniquely identify a building within the system.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Name of the building. Provides a human-readable identifier for the building.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Additional remarks about the building. Can include any notes or additional information
     * relevant to the building.
     */
    @JsonProperty("remarks")
    private String remarks;

    /**
     * A slug for the building, providing a URL-friendly string identifier. It's used for creating
     * more readable URLs that reference the building.
     * By default, it is an empty string indicating that it can be optionally provided.
     */
    @JsonProperty("slug")
    @Builder.Default
    private String slug = "";
}
