package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
public class PopulationBuildingDTO extends BuildingDTO {
    @JsonProperty("capacity")
    private int capacity;
}
