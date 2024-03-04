package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * for sending cost population requirement relation data
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Population_RequirementDTO{
    @JsonProperty("id")
    private String id;

    @JsonProperty("good_id")
    private String goodId;

    @JsonProperty("population_id")
    private String populationId;

    @JsonProperty("consumption")
    private float consumption;

    @JsonProperty("produce")
    private float produce;

    @JsonProperty("isBasic")
    private boolean isBasic;
}
