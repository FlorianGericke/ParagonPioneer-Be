package com.example.ppapi.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Population_RequirementDTO{
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("good_id")
    private UUID goodId;

    @JsonProperty("population_id")
    private UUID populationId;

    @JsonProperty("consumption")
    private float consumption;

    @JsonProperty("income")
    private float income;

    @JsonProperty("isBasic")
    private boolean isBasic;
}
