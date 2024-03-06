package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for conveying information about the association between buildings and goods,
 * particularly focusing on the cost aspect. This DTO is used to transfer data related to how much of a specific
 * good is required by a building, effectively representing a row in the cost-building-goods relationship table
 * in a more accessible and transferable format.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cost_Building_GoodsDTO {

    /**
     * The unique identifier of the cost-building-goods relationship. This ID is used to uniquely identify
     * a specific relation instance in the system.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The identifier of the building involved in the relationship. It references the specific building
     * that requires the good as part of its construction or maintenance cost.
     */
    @JsonProperty("building_id")
    private String buildingId;

    /**
     * The identifier of the good involved in the relationship. It references the specific good that is
     * required by the building, as identified by the buildingId.
     */
    @JsonProperty("good_id")
    private String goodId;

    /**
     * The amount of the specified good (goodId) that is required by the building (buildingId). This field
     * quantifies the relationship, indicating how much of the good is needed.
     */
    @JsonProperty("amount")
    private int amount;
}
