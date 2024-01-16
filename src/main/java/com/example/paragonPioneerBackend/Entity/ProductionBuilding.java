package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Set;

/**
 * Entity representing a ProductionBuilding
 */
@Entity
@Getter
@Setter
@ToString
public class ProductionBuilding extends Building {

    @Column(name="production_per_minute")
    private float productionPerMinute = 0;

    @OneToOne()
    @JoinColumn(name = "recipe")
    private Recipe recipe = null;

    /**
     *Constructs a new instance of ProductionBuilding
     * @param name of the ProductionBuilding
     * @param remarks additional information about the ProductionBuilding
     * @param costs of the ProductionBuilding
     * @param requirementPopulationBuildings requirement population of the ProductionBuilding
     * @param productionPerMinute the amount of items the building can produce in on Minute
     * @param recipe the production recipe of the building
     */
    @Builder
    public ProductionBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, Requirement_Population_Building requirementPopulationBuildings, float productionPerMinute, Recipe recipe) {
        super(name, remarks, costs,requirementPopulationBuildings);
        this.productionPerMinute = productionPerMinute;
        this.recipe = recipe;
    }

    /**
     * Default constructor
     */
    public ProductionBuilding() {
    }
}
