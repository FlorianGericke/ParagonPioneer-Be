package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
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
public class PopulationBuilding extends Building {

    /**
     * The capacity indicates the maximum number of persons that the population building can accommodate.
     */
    private int capacity;

    /**
     * Constructs a new instance of PopulationBuilding with detailed attributes.
     *
     * @param name the name of the PopulationBuilding, inherited from {@link Building}.
     * @param remarks additional information about the PopulationBuilding, inherited from {@link Building}.
     * @param costs a set of costs associated with constructing or maintaining the PopulationBuilding,
     *              represented by {@link Cost_Building_Goods}.
     * @param requirementPopulationBuildings the population requirements for the building,
     *                                       represented by {@link Requirement_Population_Building}.
     * @param capacity the maximum number of persons the building can accommodate.
     * @param slug the unique slug for the PopulationBuilding, used for URL representation, inherited from {@link Building}.
     */
    @Builder
    public PopulationBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, Requirement_Population_Building requirementPopulationBuildings, int capacity, String slug) {
        super(name, remarks, costs, requirementPopulationBuildings, slug);
        this.capacity = capacity;
    }

    /**
     * Default constructor for PopulationBuilding, required for JPA entity initialization.
     */
    public PopulationBuilding() {
        super();
    }
}
