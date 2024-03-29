package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Spring Data JPA repository interface for {@link CostBuildingGoods} entities.
 * This repository facilitates the creation, retrieval, update, and deletion (CRUD) operations
 * for cost-building-goods relations, along with pagination and sorting capabilities inherited
 * from the JpaRepository interface. The {@link CostBuildingGoods} entity links buildings and goods
 * in a many-to-many relationship, specifying the amount of a good required for a building.
 *
 * As a part of the application's data access layer, this repository abstracts the underlying
 * data store, enabling easy data access and manipulation without the need for custom SQL.
 */
public interface CostBuildingGoodsRepository extends JpaRepository<CostBuildingGoods, UUID> {
}
