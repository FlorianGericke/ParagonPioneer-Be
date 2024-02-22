package com.example.paragonPioneerBackend.Bin.Config.Data;

import com.example.paragonPioneerBackend.Service.Authservices.AuthenticationService;
import com.example.paragonPioneerBackend.Dto.RegisterRequest;
import com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Execute all runner in correct Order. To set up relations correctly
 */
@Configuration
@RequiredArgsConstructor
public class InsertRunner implements ApplicationRunner {
    private final AuthenticationService authenticationService;

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
        authenticationService.register(RegisterRequest.builder()
                .email("amin@user.de")
                .password("admin")
                .build());

        goodInserter.run();
        recipeInserter.run();
        populationInserter.run();
        buildingInserter.run();
        costBuildingGoodsInserter.run();
        populationRequirementInserter.run();
        costBuildingPopulation.run();
    }
}
