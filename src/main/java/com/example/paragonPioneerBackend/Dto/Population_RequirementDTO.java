package com.example.paragonPioneerBackend.Dto;

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

    @JsonProperty("produce")
    private float produce;

    @JsonProperty("isBasic")
    private boolean isBasic;
}
