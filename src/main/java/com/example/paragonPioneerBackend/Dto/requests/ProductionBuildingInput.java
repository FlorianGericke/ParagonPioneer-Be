package com.example.paragonPioneerBackend.Dto.requests;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Data Transfer Object (DTO) for conveying information about buildings within the application.
 * This DTO is used to transfer building data, including the building's name, remarks, and unique identifier,
 * between different layers of the application, such as the service and controller layers, or to external interfaces
 * like RESTful APIs.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductionBuildingInput extends BuildingInput {

    /**
     * The rate at which the production building produces goods, measured in units per minute.
     * This rate is crucial for calculating production outputs over time.
     */
    @Builder.Default
    private Float productionPerMinute = null;

    /**
     * The unique identifier of the recipe associated with this production building.
     * This ID links the building to a specific recipe, detailing the inputs and output good
     * produced by the production process.
     */
    @Builder.Default
    private String recipe = null;
}