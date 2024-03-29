package com.example.paragonPioneerBackend.Dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for sending data about the relationship between buildings and population segments
 * within the application. This DTO facilitates the transfer of information that specifies the amount of population
 * required by a particular building, useful for operations involving the management, display, or analysis of
 * population requirements for buildings.
 */
@Data
@Builder
public class RequirementPopulationBuildingInput {
    /**
     * The unique identifier of the building involved in the relationship. This ID links the DTO to a specific
     * building that requires a certain population segment for its operation or other purposes.
     */
    @Builder.Default
    @JsonProperty("id_slug_or_name_of_building")
    private String building = null;

    /**
     * The unique identifier of the population segment involved in the relationship. This ID links the DTO to a
     * specific population segment that is required by the building identified by {@code buildingId}.
     */
    @Builder.Default
    @JsonProperty("id_slug_or_name_of_population")
    private String population = null;

    /**
     * The amount of the specified population segment required by the building. This field quantifies the
     * population requirement, indicating how many individuals or units from the population segment are needed
     * by the building for its operation or for fulfilling other specified criteria.
     */
    @Builder.Default
    @JsonProperty("amount")
    private Integer amount = null;
}