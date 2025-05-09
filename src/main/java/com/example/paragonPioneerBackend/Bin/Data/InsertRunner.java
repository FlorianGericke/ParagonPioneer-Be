package com.example.paragonPioneerBackend.Bin.Data;

import com.example.paragonPioneerBackend.Bin.Data.EntityInserters.*;
import com.example.paragonPioneerBackend.Bin.Security.AuthServices.AuthenticationService;
import com.example.paragonPioneerBackend.Bin.Security.Requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import me.tongfei.progressbar.ProgressBar;
import org.springframework.beans.factory.annotation.Value;
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

    // Environment Vars
    @Value("${api.security.admin.mail}")
    private String adminMail;
    @Value("${api.security.admin.password}")
    private String adminPassword;
    @Value("${spring.jpa.hibernate.ddl-auto:}")
    private String ddlAuto;
    @Value("${api.domain:}")
    private String apiDomain;
    @Value("${api.port:}")
    private String apiPort;

    /**
     * Executes the data insertion tasks in the prescribed order when the application starts.
     * This method is automatically called by the Spring Boot framework, providing an entry point
     * for running the inserter components.
     *
     * @param args Application arguments passed at startup, not directly used by this method.
     */
    @Override
    public void run(ApplicationArguments args) {
        long amount = goodInserter.getInsertsLength() + populationInserter.getInsertsLength() +
                recipeInserter.getInsertsLength() + populationRequirementInserter.getInsertsLength() +
                buildingInserter.getInsertsLength();

        if (ddlAuto.matches("(?i)create-drop|create|update")) {
            try (ProgressBar pb = new ProgressBar("Data Insertion", amount + 1)) {
                authenticationService.register(new RegisterRequest(adminMail, adminPassword));
                pb.step();

                goodInserter.run(pb::step);
                recipeInserter.run(pb::step);
                buildingInserter.run(pb::step);
                populationInserter.run(pb::step);
                populationRequirementInserter.run(pb::step);
                costBuildingGoodsInserter.run(pb::step);
                costBuildingPopulation.run(pb::step);
            } catch (Exception ignored) {
            }
        } else {
            try {
                authenticationService.register(new RegisterRequest(adminMail, adminPassword));
            } catch (Exception ignored) {
            }
        }
        System.out.println("CMS Server: http://" + apiDomain+":"+apiPort+"/swagger-ui/index.html");
    }
}
