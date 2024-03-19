package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller responsible for handling HTTP requests related to Population entities.
 * Inherits the basic CRUD functionalities from BaseController and adds specialized
 * functionality for querying populations based on specific criteria, such as name.
 * Utilizes PopulationService for all operations, ensuring that business logic and
 * database interactions are encapsulated within the service layer.
 */
@Controller
@RequestMapping(path = "/api/v1/population")
public class PopulationController extends BaseController<Population, PopulationRepository, PopulationDTO, PopulationService> {

    /**
     * Constructs a new PopulationController with dependency injection for the PopulationService.
     * This service is responsible for executing the business logic associated with Population entities.
     *
     * @param service The PopulationService instance used by this controller to interact with population data.
     */
    @Autowired
    public PopulationController(PopulationService service) {
        super(service);
    }

    /**
     * Retrieves a list of Population entities whose names contain the specified substring.
     * This endpoint is useful for implementing search functionalities within the application,
     * allowing users to find populations by partial names.
     *
     * @param name The substring to search for within the names of Population entities.
     * @return A list of Population entities that match the search criterion.
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Population> getEntities(@RequestParam String name) {
        return service.findAllByNameContains(name);
    }
}
