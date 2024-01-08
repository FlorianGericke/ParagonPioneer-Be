package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class ProductionBuilding extends Building {

    @Column(name="production_per_minute", nullable = true)
    private float productionPerMinute = 0;

    @OneToOne()
    @JoinColumn(name = "recipe", nullable = true)
    private Recipe recipe = null;

    @Builder
    public ProductionBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, Requirement_Population_Building requirementPopulationBuildings, float productionPerMinute, Recipe recipe) {
        super(name, remarks, costs,requirementPopulationBuildings);
        this.productionPerMinute = productionPerMinute;
        this.recipe = recipe;
    }

    public ProductionBuilding() {
    }
}
