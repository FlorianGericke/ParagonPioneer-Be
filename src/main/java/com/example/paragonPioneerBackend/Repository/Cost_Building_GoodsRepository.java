package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Spring Data JPA repository interface for {@link Cost_Building_Goods} entities.
 * This repository facilitates the creation, retrieval, update, and deletion (CRUD) operations
 * for cost-building-goods relations, along with pagination and sorting capabilities inherited
 * from the JpaRepository interface. The {@link Cost_Building_Goods} entity links buildings and goods
 * in a many-to-many relationship, specifying the amount of a good required for a building.
 *
 * As a part of the application's data access layer, this repository abstracts the underlying
 * data store, enabling easy data access and manipulation without the need for custom SQL.
 */
public interface Cost_Building_GoodsRepository extends JpaRepository<Cost_Building_Goods, UUID> {
}
