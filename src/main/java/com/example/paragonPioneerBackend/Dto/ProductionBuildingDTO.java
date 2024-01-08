package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * DTO for sending Production Building data
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@SuperBuilder
public class ProductionBuildingDTO extends BuildingDTO {
    @JsonProperty("production_per_minute")
    private float productionPerMinute;

    @JsonProperty("id_of_recipe")
    private UUID idOfRecipe ;

    public ProductionBuildingDTO(){
    }

    public ProductionBuildingDTO(UUID id, String name, String remarks, float productionPerMinute, UUID idOfRecipe) {
        super(id, name, remarks);
        this.productionPerMinute = productionPerMinute;
        this.idOfRecipe = idOfRecipe;
    }

    public ProductionBuildingDTO(float productionPerMinute, UUID idOfRecipe) {
        this.productionPerMinute = productionPerMinute;
        this.idOfRecipe = idOfRecipe;
    }
}
