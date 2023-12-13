package com.example.ppapi.Repository;


import com.example.ppapi.Entity.JoinTables.Cost_Building_Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Cost_Building_PopulationRepository extends JpaRepository<Cost_Building_Population, UUID> {
}
