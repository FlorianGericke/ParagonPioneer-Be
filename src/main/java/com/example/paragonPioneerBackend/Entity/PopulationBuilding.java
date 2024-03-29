package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Set;

/**
 * Represents a specific type of building that houses a population within the application.
 * This entity extends the {@link Building} class to inherit common building attributes while adding specific features
 * associated with population capacities, such as the number of persons it can accommodate.
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PopulationBuilding extends Building {

    /**
     * The capacity indicates the maximum number of persons that the population building can accommodate.
     */
    private int capacity;

    @Builder
    public PopulationBuilding(String name, String slug, String remarks, Set<CostBuildingGoods> costs, RequirementPopulationBuilding requirePopulation, int capacity) {
        super(name, slug, remarks, costs, requirePopulation);
        this.capacity = capacity;
    }
}
