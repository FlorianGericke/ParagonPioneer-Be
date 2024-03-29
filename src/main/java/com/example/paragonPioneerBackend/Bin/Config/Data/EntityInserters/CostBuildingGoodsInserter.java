package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.CostBuildingGoodsInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.BuildingService;
import com.example.paragonPioneerBackend.Service.CostBuildingGoodsService;
import com.example.paragonPioneerBackend.Service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Component responsible for seeding the database with initial data for cost-building-goods relations.
 * It utilizes the Cost_Building_GoodsService, BuildingService, and GoodService to create associations
 * based on predefined records, ensuring the application has a baseline set of data for managing
 * the cost requirements of various buildings in relation to specific goods. This class is particularly
 * useful for development and testing environments, where a consistent starting point for data is beneficial.
 */
@Component
@RequiredArgsConstructor
public class CostBuildingGoodsInserter {
    private final CostBuildingGoodsService costBuildingGoodsService;
    private final BuildingService<?> buildingService;
    private final GoodService goodService;

    /**
     * Record to store the initial setup data for each cost-building-goods relation,
     * including the building name, the good name, and the amount of the good required.
     */
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
            //todo add more cost-building-goods relations
    };

    /**
     * Executes the insertion of the predefined cost-building-goods data into the database.
     * It resolves the IDs of buildings and goods based on their names and creates associations
     * that specify the cost in terms of goods required for each building. This method ensures
     * the application is populated with essential data regarding the construction costs of buildings.
     */
    public void run() {
        for (Inserter insert : inserts) {
            try {
                costBuildingGoodsService.post(
                        CostBuildingGoodsInput.builder()
                                .good(goodService.findByIdSlugName(insert.goodName).getId().toString())
                                .building(buildingService.findByIdSlugName(insert.buildingName).getId().toString())
                                .amount(insert.amount)
                                .build()
                );
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create CostBuildingGoods for Good " + insert.goodName + " and Building " + insert.buildingName);
            }
        }
    }
}