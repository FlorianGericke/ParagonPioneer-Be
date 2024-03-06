package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for conveying population-related information within the application.
 * It's used primarily to transfer essential data about population segments, including their unique identifier,
 * name, and a slug for URL representation. This class simplifies the process of sending and receiving population
 * data across different application layers or through web APIs, ensuring that sensitive or unnecessary details
 * are not exposed.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class PopulationDTO {

    /**
     * The unique identifier of the population segment. This ID is crucial for identifying specific
     * population segments within the system and for database operations.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The name of the population segment. This provides a human-readable identifier that can be used
     * in user interfaces and reports.
     */
    @JsonProperty("name")
    private String name;

    /**
     * A slug for the population segment, providing a URL-friendly string identifier. Slugs are particularly
     * useful for creating readable and SEO-friendly URLs in web applications. By default, it is initialized
     * as an empty string, indicating that it can be optionally provided.
     */
    @JsonProperty("slug")
    @Builder.Default
    private String slug = "";
}
