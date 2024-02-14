package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * DTO for sending cost building goods relation data
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cost_Building_GoodsDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("building_id")
    private String buildingId;

    @JsonProperty("good_id")
    private String goodId;

    @JsonProperty("amount")
    private int amount;
}
