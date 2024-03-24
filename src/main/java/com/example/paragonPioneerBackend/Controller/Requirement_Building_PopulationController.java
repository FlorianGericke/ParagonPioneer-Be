package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Repository.Requirement_Population_BuildingRepository;
import com.example.paragonPioneerBackend.Service.Requirement_Building_PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing the complex relationships between building requirements and population segments.
 * It extends the generic BaseController to provide tailored CRUD operations and additional functionality
 * for handling associations that specify the population requirements for buildings. This controller uses
 * the Requirement_Building_PopulationService to perform operations on Requirement_Population_Building entities,
 * facilitating the creation, retrieval, updating, and deletion of these associations within the application.
 */
@RestController
@RequestMapping(path = "/api/v1/requirement/building_population")
public class Requirement_Building_PopulationController extends BaseController<Requirement_Population_Building, Requirement_Population_BuildingRepository, Requirement_Population_BuildingDTO, Requirement_Building_PopulationService> {

    /**
     * Autowired constructor for Dependency Injection of Requirement_Building_PopulationService.
     * The service is responsible for the business logic and database interactions related
     * to the requirement-building-population relationships, ensuring that the controller
     * can delegate complex operations to the service layer.
     *
     * @param service The Requirement_Building_PopulationService instance managing the underlying business logic.
     */
    @Autowired
    public Requirement_Building_PopulationController(Requirement_Building_PopulationService service) {
        super(service);
    }
}
