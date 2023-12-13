package com.example.ppapi.Runners;

import com.example.ppapi.Entity.JoinTables.Cost_Building_Population;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertRunner implements ApplicationRunner {
    private final BuildingInserter buildingInserter;
    private final Cost_Building_goodsInserter costBuildingGoodsInserter;
    private final GoodInserter goodInserter;
    private final PopulationInserter populationInserter;
    private final Population_RequirementInserter populationRequirementInserter;
    private final Cost_Building_PopulationInserter costBuildingPopulation;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        buildingInserter.run();
        goodInserter.run();
        populationInserter.run();
        costBuildingGoodsInserter.run();
        populationRequirementInserter.run();
        costBuildingPopulation.run();
    }
}
