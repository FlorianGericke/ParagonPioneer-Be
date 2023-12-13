package com.example.ppapi.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cost_Building_PopulationDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("building_id")
    private UUID buildingId;

    @JsonProperty("population_id")
    private UUID populationId;

    @JsonProperty("amount")
    private int amount;
}
