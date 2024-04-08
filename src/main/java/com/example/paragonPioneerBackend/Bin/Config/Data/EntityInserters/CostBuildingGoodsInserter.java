package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.requests.CostBuildingGoodsInput;
import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import com.example.paragonPioneerBackend.Service.BuildingService;
import com.example.paragonPioneerBackend.Service.CostBuildingGoodsService;
import com.example.paragonPioneerBackend.Service.GoodService;
import lombok.RequiredArgsConstructor;
import me.tongfei.progressbar.ProgressBar;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Supplier;

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
     * Returns the number of data insertion tasks for cost-building-goods relations.
     *
     * @return The number of data insertion tasks.
     */
    public int getInsertsLength() {
        return inserts.length;
    }

    /**
     * Executes the data insertion tasks for cost-building-goods relations.
     * This method is called by the InsertRunner component, providing an entry point
     * for running the inserter components.
     *
     * @param progressBarSupplier Supplier for a progress bar to display the insertion progress.
     */
    public void run(Supplier<ProgressBar> progressBarSupplier) {
        for (Inserter insert : inserts) {
            try {
                costBuildingGoodsService.post(
                        CostBuildingGoodsInput.builder()
                                .good(goodService.findSmthByIdSlugName(insert.goodName).getId().toString())
                                .building(buildingService.findSmthByIdSlugName(insert.buildingName).getId().toString())
                                .amount(insert.amount)
                                .build()
                );
            } catch (ParagonPioneerBeException e) {
                System.out.println("Could not create CostBuildingGoods for Good " + insert.goodName + " and Building " + insert.buildingName);
            }finally {
                progressBarSupplier.get();
            }
        }
    }
}