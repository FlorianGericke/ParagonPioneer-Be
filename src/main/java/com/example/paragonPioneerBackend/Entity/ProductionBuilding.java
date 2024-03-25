package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Represents a production building within the application. This type of building is focused on the production
 * of goods at a specified rate and according to a specific recipe. It inherits common building attributes from
 * the {@link Building} class and introduces production-specific properties like production rate and recipe.
 */
@Entity
@Getter
@Setter
@ToString
public class ProductionBuilding extends Building {

    /**
     * Specifies the production rate of the building in terms of items produced per minute.
     */
    @Column(name="production_per_minute")
    private float productionPerMinute = 0;

    /**
     * The recipe that dictates what goods are produced by this building, including the required input goods
     * and their quantities. This relationship is represented as a one-to-one linkage to the {@link Recipe} entity.
     */
    @OneToOne()
    @JoinColumn(name = "recipe")
    private Recipe recipe = null;

    /**
     * Constructs a new instance of ProductionBuilding with specified attributes, including production details
     * and the recipe used for production.
     *
     * @param name The name of the ProductionBuilding, inherited from {@link Building}.
     * @param remarks Additional information about the ProductionBuilding, inherited from {@link Building}.
     * @param costs A set of costs associated with constructing or maintaining the ProductionBuilding,
     *              represented by {@link Cost_Building_Goods}.
     * @param requirementPopulationBuildings The population requirements for the building,
     *                                       represented by {@link Requirement_Population_Building}.
     * @param productionPerMinute The production rate of the building, specifying how many items it can produce per minute.
     * @param recipe The production recipe of the building, detailing the required inputs and their quantities for production.
     * @param slug The unique slug for the ProductionBuilding, used for URL representation, inherited from {@link Building}.
     */
    @Builder
    public ProductionBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, Requirement_Population_Building requirementPopulationBuildings, float productionPerMinute, Recipe recipe, String slug) {
        super(name, remarks, costs, requirementPopulationBuildings, slug);
        this.productionPerMinute = productionPerMinute;
        this.recipe = recipe;
    }

    /**
     * Default constructor for ProductionBuilding, required for JPA entity initialization.
     */
    public ProductionBuilding() {
    }
}
