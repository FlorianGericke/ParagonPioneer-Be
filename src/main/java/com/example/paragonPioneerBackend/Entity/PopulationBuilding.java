package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Population;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class PopulationBuilding extends Building {

    private int capacity;

    @OneToOne(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    Cost_Building_Population population;

    @Builder
    public PopulationBuilding(String name, String remarks, Set<Cost_Building_Goods> costs, int capacity) {
        super(name, remarks, costs);
        this.capacity = capacity;
    }

    public PopulationBuilding() {

    }
}
