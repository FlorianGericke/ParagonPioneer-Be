package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class PopulationBuilding extends Building {

    private int capacity = 0;

    @Builder
    public PopulationBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, Requirement_Population_Building requirementPopulationBuildings, int capacity) {
        super(name, remarks, costs, requirementPopulationBuildings);
        this.capacity = capacity;
    }

    public PopulationBuilding() {

    }
}
