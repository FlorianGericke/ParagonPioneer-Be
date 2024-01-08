package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class ProductionBuilding extends Building {

    @Builder
    public ProductionBuilding(String name, String remarks, Set<Cost_Building_Goods> costs) {
        super(name, remarks, costs);
    }

    public ProductionBuilding() {
    }
}
