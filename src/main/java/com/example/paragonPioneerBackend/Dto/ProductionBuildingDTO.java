package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@Getter
@Setter
@SuperBuilder
public class ProductionBuildingDTO extends BuildingDTO {
    @JsonProperty("production_per_minute")
    private float productionPerMinute = 0;

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
