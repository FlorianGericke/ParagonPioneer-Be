package com.example.paragonPioneerBackend.Runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Execute all runner in correct Order. To set up relations correctly
 */
@Component
@RequiredArgsConstructor
public class InsertRunner implements ApplicationRunner {
    private final GoodInserter goodInserter;
    private final RecipeInserter recipeInserter;
    private final PopulationInserter populationInserter;
    private final BuildingInserter buildingInserter;
    private final Cost_Building_goodsInserter costBuildingGoodsInserter;
    private final Population_RequirementInserter populationRequirementInserter;
    private final Requirement_Population_BuildingInserter costBuildingPopulation;

    /**
     * function called when application is started
     *
     * @param args the application arguments
     */
    @Override
    public void run(ApplicationArguments args) {
        goodInserter.run();
        populationInserter.run();
        recipeInserter.run();
        populationRequirementInserter.run();
        buildingInserter.run();
        costBuildingGoodsInserter.run();
        costBuildingPopulation.run();
    }
}
