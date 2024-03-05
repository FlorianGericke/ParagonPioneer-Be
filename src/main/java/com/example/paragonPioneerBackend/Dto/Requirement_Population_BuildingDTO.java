package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * for sending requirement population building relation data
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Requirement_Population_BuildingDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("building_id")
    private String buildingId;

    @JsonProperty("population_id")
    private String populationId;

    @JsonProperty("amount")
    private int amount;
}
