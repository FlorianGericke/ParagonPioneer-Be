package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cost_Building_GoodsDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("building_id")
    private UUID buildingId;

    @JsonProperty("good_id")
    private UUID goodId;

    @JsonProperty("amount")
    private int amount;
}
