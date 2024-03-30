package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.BaseController;
import com.example.paragonPioneerBackend.Dto.requests.PopulationRequirementInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.PopulationRequirementMapper;
import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import com.example.paragonPioneerBackend.Repository.PopulationRequirementRepository;
import com.example.paragonPioneerBackend.Service.PopulationRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PopulationRequirementController is a REST controller that manages the relationships between populations and their requirements.
 * It extends the BaseController and provides CRUD operations for the population-requirement relationship.
 * This enables the management of how population segments have certain requirements.
 *
 * The PopulationRequirementController class is parameterized with the following types:
 * - PopulationRequirement: The entity type that this controller handles.
 * - PopulationRequirementRepository: The repository type used for accessing the database.
 * - PopulationRequirementInput: The DTO type used for creating and updating population-requirement relationships.
 * - PopulationRequirementMapper: The mapper type used for converting between entities and DTOs.
 * - PopulationRequirementService: The service type used for business logic operations.
 */
@RestController
@RequestMapping(path = "/api/v1/requirement")
public class PopulationRequirementController extends BaseController<PopulationRequirement, PopulationRequirementRepository, PopulationRequirementInput, PopulationRequirementMapper, PopulationRequirementService> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     * The PopulationRequirementService is autowired, meaning Spring automatically handles the injection of this dependency.
     *
     * @param service The service used for business logic operations.
     */
    @Autowired
    public PopulationRequirementController(PopulationRequirementService service) {
        super(service, new PopulationRequirementMapper());
    }
}