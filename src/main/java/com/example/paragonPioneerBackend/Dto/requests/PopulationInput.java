package com.example.paragonPioneerBackend.Dto.requests;

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
@Builder
public class PopulationInput {
    /**
     * The name of the population segment. This provides a human-readable identifier that can be used
     * in user interfaces and reports.
     */
    @JsonProperty("name")
    @Builder.Default
    private String name = null;
}