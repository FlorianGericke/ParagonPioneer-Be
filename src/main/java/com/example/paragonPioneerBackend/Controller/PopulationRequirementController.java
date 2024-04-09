package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.BaseController;
import com.example.paragonPioneerBackend.Dto.requests.PopulationRequirementInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.PopulationRequirementMapper;
import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import com.example.paragonPioneerBackend.Repository.PopulationRequirementRepository;
import com.example.paragonPioneerBackend.Service.PopulationRequirementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is a controller for managing population requirements.
 * It extends from the BaseController class and provides endpoints for managing population requirements.
 * It is annotated with @RestController, meaning it's a controller where every method returns a domain object instead of a view.
 * It's also annotated with @RequestMapping to map web requests onto specific handler methods.
 */
@RestController
@RequestMapping(path = "/api/v1/requirement/population")
@Tag(name = "Population Requirement", description = "Endpoints for managing population requirements")
public class PopulationRequirementController extends BaseController<PopulationRequirement, PopulationRequirementRepository, PopulationRequirementInput, PopulationRequirementMapper, PopulationRequirementService> {

    /**
     * This is a constructor for the PopulationRequirementController class.
     * It takes in a service and a mapper as parameters and passes them to the superclass constructor.
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public PopulationRequirementController(PopulationRequirementService service, PopulationRequirementMapper mapper) {
        super(service, mapper);
    }
}