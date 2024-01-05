package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertRunner implements ApplicationRunner {
    private final GoodInserter goodInserter;
    private final RecipeInserter recipeInserter;
    private final PopulationInserter populationInserter;
    private final BuildingInserter buildingInserter;
    private final Cost_Building_goodsInserter costBuildingGoodsInserter;
    private final Population_RequirementInserter populationRequirementInserter;
    private final Cost_Building_PopulationInserter costBuildingPopulation;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        goodInserter.run();
        recipeInserter.run();
        populationInserter.run();
        buildingInserter.run();
        costBuildingGoodsInserter.run();
        populationRequirementInserter.run();
        costBuildingPopulation.run();
    }
}
