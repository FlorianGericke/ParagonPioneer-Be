package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@Getter
@Setter
@SuperBuilder
public class PopulationBuildingDTO extends BuildingDTO {
    @JsonProperty("capacity")
    private int capacity;

    public PopulationBuildingDTO(UUID id, String name, String remarks, int capacity) {
        super(id, name, remarks);
        this.capacity = capacity;
    }

    public PopulationBuildingDTO(int capacity) {
        this.capacity = capacity;
    }
}
