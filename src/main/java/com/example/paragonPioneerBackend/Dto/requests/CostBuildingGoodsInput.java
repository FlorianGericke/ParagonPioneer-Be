package com.example.paragonPioneerBackend.Dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for conveying information about the association between buildings and goods,
 * particularly focusing on the cost aspect. This DTO is used to transfer data related to how much of a specific
 * good is required by a building, effectively representing a row in the cost-building-goods relationship table
 * in a more accessible and transferable format.
 */
@Data
@Builder
public class CostBuildingGoodsInput {

    /**
     * The identifier of the building involved in the relationship. It references the specific building
     * that requires the good as part of its construction or maintenance cost.
     */
    @Builder.Default
    @JsonProperty("id_slug_or_name_of_building")
    private String building = null;

    /**
     * The identifier of the good involved in the relationship. It references the specific good that is
     * required by the building, as identified by the buildingId.
     */
    @Builder.Default
    @JsonProperty("id_slug_or_name_of_good")
    private String good = null;

    /**
     * The amount of the specified good (goodId) that is required by the building (buildingId). This field
     * quantifies the relationship, indicating how much of the good is needed.
     */
    @Builder.Default
    @JsonProperty("amount")
    private Integer amount = null;
}
