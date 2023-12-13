package com.example.ppapi.Repository;

import com.example.ppapi.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {
    public Building findByNameIs(String name);
}
