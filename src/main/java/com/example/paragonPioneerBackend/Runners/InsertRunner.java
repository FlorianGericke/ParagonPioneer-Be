package com.example.paragonPioneerBackend.Runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Application runner that orchestrates the execution of various data inserter components
 * to populate the database with initial data upon application startup. Ensures that data
 * insertions are executed in a specific order to maintain data integrity and correctly set up
 * entity relationships.
 * <p>
 * This component is crucial for initializing the application with a consistent and comprehensive
 * set of data, facilitating development, testing, and demonstration scenarios.
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
     * Executes the data insertion tasks in the prescribed order when the application starts.
     * This method is automatically called by the Spring Boot framework, providing an entry point
     * for running the inserter components.
     *
     * @param args Application arguments passed at startup, not directly used by this method.
     */
    @Override
    public void run(ApplicationArguments args) {
        // Order of execution is critical to ensure that dependencies between data are respected.
        goodInserter.run(); // First, insert all goods as they might be needed by other entities.
        populationInserter.run(); // Insert population data.
        recipeInserter.run(); // Insert recipes that may depend on goods.
        populationRequirementInserter.run(); // Insert population requirements, possibly depending on goods.
        buildingInserter.run(); // Insert buildings that may rely on recipes and goods.

        /*
        todo: The following inserters are commented out, indicating conditional
         execution or work in progress. Uncomment these lines as necessary when
         their dependencies are resolved.
         */

        // costBuildingGoodsInserter.run(); // Insert cost-building-goods relations.
        // costBuildingPopulation.run(); // Insert requirement-population-building relations.
    }
}
