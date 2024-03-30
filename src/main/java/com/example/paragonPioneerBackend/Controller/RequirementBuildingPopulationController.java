package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.BaseController;
import com.example.paragonPioneerBackend.Dto.requests.RequirementPopulationBuildingInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.RequirementPopulationBuildingMapper;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.example.paragonPioneerBackend.Repository.RequirementPopulationBuildingRepository;
import com.example.paragonPioneerBackend.Service.RequirementBuildingPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RequirementBuildingPopulationController is a REST controller that manages the relationships between building requirements and population segments.
 * It extends the BaseController and provides CRUD operations for the requirement-building-population relationship.
 * This enables the management of how population segments have certain requirements for buildings.
 *
 * The RequirementBuildingPopulationController class is parameterized with the following types:
 * - RequirementPopulationBuilding: The entity type that this controller handles.
 * - RequirementPopulationBuildingRepository: The repository type used for accessing the database.
 * - RequirementPopulationBuildingInput: The DTO type used for creating and updating requirement-building-population relationships.
 * - RequirementPopulationBuildingMapper: The mapper type used for converting between entities and DTOs.
 * - RequirementBuildingPopulationService: The service type used for business logic operations.
 */
@RestController
@RequestMapping(path = "/api/v1/requirement/building-population")
public class RequirementBuildingPopulationController extends BaseController<RequirementPopulationBuilding, RequirementPopulationBuildingRepository, RequirementPopulationBuildingInput, RequirementPopulationBuildingMapper, RequirementBuildingPopulationService> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     * The RequirementBuildingPopulationService is autowired, meaning Spring automatically handles the injection of this dependency.
     *
     * @param service The service used for business logic operations.
     */
    @Autowired
    public RequirementBuildingPopulationController(RequirementBuildingPopulationService service) {
        super(service, new RequirementPopulationBuildingMapper());
    }
}