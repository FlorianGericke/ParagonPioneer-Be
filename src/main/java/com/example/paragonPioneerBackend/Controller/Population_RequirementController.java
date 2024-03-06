package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.Population_RequirementDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Population_Requirement;
import com.example.paragonPioneerBackend.Repository.Population_RequirementRepository;
import com.example.paragonPioneerBackend.Service.Population_RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for managing HTTP requests related to population requirement relations within the application.
 * This controller extends the generic BaseController, providing tailored CRUD operations and additional functionalities
 * for handling the complex relationships between population segments and their requirements.
 *
 * The controller makes use of the Population_RequirementService for executing business logic associated with
 * population requirements, ensuring that requests are processed efficiently and effectively.
 *
 * @see BaseController for base functionality
 */
@Controller
@RequestMapping(path = "/api/v1/requirement")
public class Population_RequirementController extends BaseController<Population_Requirement, Population_RequirementRepository, Population_RequirementDTO, Population_RequirementService> {

    /**
     * Autowired constructor for injecting the Population_RequirementService into this controller.
     * The service is responsible for all the business logic and database interactions related to
     * population requirements.
     *
     * @param service The Population_RequirementService instance that handles business logic for population requirement relations.
     */
    @Autowired
    public Population_RequirementController(Population_RequirementService service) {
        super(service);
    }
}
