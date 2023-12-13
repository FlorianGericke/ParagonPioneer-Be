package com.example.ppapi.Runners;

import com.example.ppapi.Entity.JoinTables.Cost_Building_Goods;
import com.example.ppapi.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Cost_Building_goodsInserter{
    private final Cost_Building_GoodsRepository repository;
    private final BuildingRepository buildingRepository;
    private final GoodRepository goodRepository;

    private record Inserter(String buildingName, String goodName, int amount) {
    }

    Inserter[] inserts = {
            new Inserter("Lumberjack", "Wood", 5),
            new Inserter("Forester", "Wood", 10),
            new Inserter("Warehouse I", "Wood", 10),
            new Inserter("Pioneer's Hut", "Wood", 10),
            new Inserter("Well", "Wood", 10),
            new Inserter("Kontor I", "Wood", 40),
            new Inserter("Fisherman", "Wood", 10),
            new Inserter("Sawmill", "Wood", 20),
            new Inserter("Potato Farm", "Plank", 10)
    };

    public void run() {
        for (Inserter insert : inserts) {
            repository.save(
                    Cost_Building_Goods.builder()
                            .good(goodRepository.findByNameIs(insert.goodName))
                            .building(buildingRepository.findByNameIs(insert.buildingName))
                            .amount(insert.amount)
                            .build()
            );
        }
    }
}
