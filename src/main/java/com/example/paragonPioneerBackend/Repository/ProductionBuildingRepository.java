package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductionBuildingRepository extends JpaRepository<ProductionBuilding, UUID> {
    public ProductionBuilding findByNameIs(String name);
}
