package com.example.paragonPioneerBackend.Dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Data Transfer Object (DTO) for conveying population building information between application layers,
 * particularly useful for operations involving the creation, update, or retrieval of population building data
 * through user interfaces or APIs. This DTO extends {@link BuildingInput} with additional attributes specific
 * to buildings that accommodate population, such as their capacity.
 */

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PopulationBuildingInput extends BuildingInput {

    /**
     * The capacity of the population building, indicating the maximum number of individuals
     * or units that the building can accommodate.
     */
    @Builder.Default
    @JsonProperty("capacity")
    private Integer capacity = null;
}