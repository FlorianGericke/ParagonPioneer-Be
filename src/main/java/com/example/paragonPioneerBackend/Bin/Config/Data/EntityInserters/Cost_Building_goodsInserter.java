package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.Cost_Building_GoodsDTO;
import com.example.paragonPioneerBackend.Service.EntityServices.BuildingService;
import com.example.paragonPioneerBackend.Service.EntityServices.Cost_Building_GoodsService;
import com.example.paragonPioneerBackend.Service.EntityServices.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
/**
 * Setup all data for relation cost building goods
 */
@Component
@RequiredArgsConstructor
public class Cost_Building_goodsInserter{
    private final Cost_Building_GoodsService costBuildingGoodsService;
    private final BuildingService<?> buildingService;
    private final GoodService goodService;

    private record Inserter(String buildingName, String goodName, int amount) {
    }

    private final Inserter[] inserts = {
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

    /**
     * Run the insertions
     */
    public void run() {
        for (Inserter insert : inserts) {
            String buildingId = null;

            if (buildingService.findByName(insert.buildingName).isPresent()) {
                buildingId = Objects.requireNonNull(buildingService.findByName(insert.buildingName).orElse(null)).getId().toString();
            }

            costBuildingGoodsService.post(
                    Cost_Building_GoodsDTO.builder()
                            .goodId(Objects.requireNonNull(goodService.findByName(insert.goodName).orElse(null)).getId().toString())
                            .buildingId(buildingId)
                            .amount(insert.amount)
                            .build()
            );
        }
    }
}
