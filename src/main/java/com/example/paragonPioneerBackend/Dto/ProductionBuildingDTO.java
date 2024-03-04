package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
    @Builder.Default
    private String idOfRecipe = null;

    /**
     * default constructor
     */
    public ProductionBuildingDTO(){
    }

    /**
     * Constructor for creating a new instance of ProductionBuildingDTO
     * @param id of the instance
     * @param name  of the instance
     * @param remarks  of the instance
     * @param productionPerMinute  of the instance
     * @param idOfRecipe  of the instance
     */
    public ProductionBuildingDTO(String id, String name, String remarks, float productionPerMinute, String idOfRecipe, String slug) {
        super(id, name, remarks, slug);
        this.productionPerMinute = productionPerMinute;
        this.idOfRecipe = idOfRecipe;
    }

    /**
     * Constructor for creating a new instance of ProductionBuildingDTO
     * @param productionPerMinute  of the instance
     * @param idOfRecipe  of the instance
     */
    public ProductionBuildingDTO(float productionPerMinute, String idOfRecipe) {
        this.productionPerMinute = productionPerMinute;
        this.idOfRecipe = idOfRecipe;
    }
}
