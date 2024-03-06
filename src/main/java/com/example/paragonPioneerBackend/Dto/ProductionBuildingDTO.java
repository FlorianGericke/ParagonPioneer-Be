package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Extends {@link BuildingDTO} to provide a Data Transfer Object specific to production buildings.
 * This DTO includes additional fields pertinent to production buildings, such as their production rate
 * and associated recipe ID, facilitating the transfer of production building data within the application
 * and to external interfaces like RESTful APIs.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@SuperBuilder
public class ProductionBuildingDTO extends BuildingDTO {
    /**
     * The rate at which the production building produces goods, measured in units per minute.
     * This rate is crucial for calculating production outputs over time.
     */
    @JsonProperty("production_per_minute")
    private float productionPerMinute;

    /**
     * The unique identifier of the recipe associated with this production building.
     * This ID links the building to a specific recipe, detailing the inputs and output good
     * produced by the production process.
     */
    @JsonProperty("id_of_recipe")
    @Builder.Default
    private String idOfRecipe = null;

    /**
     * Default constructor for creating an instance of ProductionBuildingDTO without initialization.
     */
    public ProductionBuildingDTO(){
        super();
    }

    /**
     * Constructs a new instance of ProductionBuildingDTO with detailed attributes including production rate
     * and recipe ID, in addition to the base building attributes.
     *
     * @param id The unique identifier of the building.
     * @param name The name of the building.
     * @param remarks Additional information or comments about the building.
     * @param productionPerMinute The production rate of the building.
     * @param idOfRecipe The unique identifier of the recipe associated with this building.
     * @param slug The slug for URL-friendly identification of the building.
     */
    public ProductionBuildingDTO(String id, String name, String remarks, float productionPerMinute, String idOfRecipe, String slug) {
        super(id, name, remarks, slug);
        this.productionPerMinute = productionPerMinute;
        this.idOfRecipe = idOfRecipe;
    }

    /**
     * Constructs a new instance of ProductionBuildingDTO specifying only the production-specific attributes.
     *
     * @param productionPerMinute The production rate of the building.
     * @param idOfRecipe The unique identifier of the recipe associated with this building.
     */
    public ProductionBuildingDTO(float productionPerMinute, String idOfRecipe) {
        super(); // Initialize with default super constructor
        this.productionPerMinute = productionPerMinute;
        this.idOfRecipe = idOfRecipe;
    }
}
