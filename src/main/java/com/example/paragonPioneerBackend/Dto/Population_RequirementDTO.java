package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * DTO class for transferring data related to the requirements of a population segment within the application.
 * It encompasses details about goods consumed or produced by the population, including the rate of consumption
 * and production, as well as identifying basic necessities for the population. This class is particularly useful
 * for CRUD operations on population requirements and for displaying this information in user interfaces or API responses.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Population_RequirementDTO {
    /**
     * The unique identifier of the population requirement relationship. This ID allows for the unique referencing
     * of each population requirement within the system.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The identifier of the good associated with this requirement. It references the specific good that is
     * consumed or produced by the population segment identified by {@code populationId}.
     */
    @JsonProperty("good_id")
    private String goodId;

    /**
     * The identifier of the population segment associated with this requirement. It references the specific
     * population segment that consumes or produces the good identified by {@code goodId}.
     */
    @JsonProperty("population_id")
    private String populationId;

    /**
     * The rate at which the specified good is consumed by the population segment. This field quantifies
     * the consumption needs of the population for the good.
     */
    @JsonProperty("consumption")
    private float consumption;

    /**
     * The rate at which the specified good is produced by the population segment. This field quantifies
     * the production output of the population for the good.
     */
    @JsonProperty("produce")
    private float produce;

    /**
     * A flag indicating whether the specified good is considered a basic necessity for the population segment.
     * Basic necessities are essential for the survival or well-being of the population.
     */
    @JsonProperty("isBasic")
    private boolean isBasic;
}
