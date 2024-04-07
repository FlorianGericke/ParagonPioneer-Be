package com.example.paragonPioneerBackend.Bin.Config.Data;

//import com.example.paragonPioneerBackend.Bin.Security.AuthServices.AuthenticationService;
//import com.example.paragonPioneerBackend.Bin.Security.Requests.RegisterRequest;

import com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters.*;
import com.example.paragonPioneerBackend.Bin.Security.AuthServices.AuthenticationService;
import com.example.paragonPioneerBackend.Bin.Security.Requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Application runner that orchestrates the execution of various data inserter components
 * to populate the database with initial data upon application startup. Ensures that data
 * insertions are executed in a specific order to maintain data integrity and correctly set up
 * entity relationships.
 * <p>
 * This component is crucial for initializing the application with a consistent and comprehensive
 * set of data, facilitating development, testing, and demonstration scenarios.
 */
@Configuration
@RequiredArgsConstructor
public class InsertRunner implements ApplicationRunner {
    private final AuthenticationService authenticationService;

    private final GoodInserter goodInserter;
    private final RecipeInserter recipeInserter;
    private final PopulationInserter populationInserter;
    private final BuildingInserter buildingInserter;
    private final CostBuildingGoodsInserter costBuildingGoodsInserter;
    private final PopulationRequirementInserter populationRequirementInserter;
    private final RequirementPopulationBuildingInserter costBuildingPopulation;

    /**
     * Executes the data insertion tasks in the prescribed order when the application starts.
     * This method is automatically called by the Spring Boot framework, providing an entry point
     * for running the inserter components.
     *
     * @param args Application arguments passed at startup, not directly used by this method.
     */
    @Override
    public void run(ApplicationArguments args) {
        // todo Hard Coded Admin login with Clear Password is just for Developing and testing. This should be set in an ignored env file
        authenticationService.register(RegisterRequest.builder()
                .email("admin@user.de")
                .password("admin")
                .build());

        goodInserter.run();
        recipeInserter.run();
        buildingInserter.run();
        populationInserter.run();
        populationRequirementInserter.run();
        costBuildingGoodsInserter.run();
        costBuildingPopulation.run();
        System.out.println("CMS Server: " + "http://localhost:8080/swagger-ui/index.html");
    }
}
