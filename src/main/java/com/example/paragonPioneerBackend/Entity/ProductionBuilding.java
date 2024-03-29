package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@NoArgsConstructor
public class ProductionBuilding extends Building {

    /**
     * Specifies the production rate of the building in terms of items produced per minute.
     */
    @Column(name = "production_per_minute")
    private float productionPerMinute = 0;

    /**
     * The recipe that dictates what goods are produced by this building, including the required input goods
     * and their quantities. This relationship is represented as a one-to-one linkage to the {@link Recipe} entity.
     */
    @OneToOne()
    @JoinColumn(name = "recipe")
    private Recipe recipe = null;

    @Builder
    public ProductionBuilding(String name, String slug, String remarks, Set<CostBuildingGoods> costs, RequirementPopulationBuilding requirePopulation, float productionPerMinute, Recipe recipe) {
        super(name, slug, remarks, costs, requirePopulation);
        this.productionPerMinute = productionPerMinute;
        this.recipe = recipe;
    }
}
