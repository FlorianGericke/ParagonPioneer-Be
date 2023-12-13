package com.example.paragonPioneerBackend.Repository;


import com.example.paragonPioneerBackend.Entity.JoinTables.Population_Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Population_RequirementRepository  extends JpaRepository<Population_Requirement, UUID> {
}
