package com.example.ppapi.Repository;


import com.example.ppapi.Entity.JoinTables.Cost_Building_Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Cost_Building_GoodsRepository extends JpaRepository<Cost_Building_Goods, UUID> {
}
