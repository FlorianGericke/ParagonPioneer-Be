package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Set;

/**
 * Entity representing a PopulationBuilding
 */
@Entity
@Getter
@Setter
@ToString
public class PopulationBuilding extends Building {

    private int capacity = 0;

    /**
     * Constructs a new instance of PopulationBuilding
     * @param name of the PopulationBuilding
     * @param remarks additional information about the PopulationBuilding
     * @param costs of the PopulationBuilding
     * @param requirementPopulationBuildings requirement population of the PopulationBuilding
     * @param capacity of persons living in the PopulationBuilding
     */
    @Builder
    public PopulationBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, Requirement_Population_Building requirementPopulationBuildings, int capacity) {
        super(name, remarks, costs, requirementPopulationBuildings);
        this.capacity = capacity;
    }

    /**
     * Default Constructor
     */
    public PopulationBuilding() {

    }
}
