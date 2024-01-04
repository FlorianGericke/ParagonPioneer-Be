package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
public class ProductionBuildingDTO extends BuildingDTO {
    @JsonProperty("hasSideCar2")
    private boolean hasSideCar2;
}
