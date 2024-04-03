package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.SlugableController;
import com.example.paragonPioneerBackend.Dto.requests.PopulationInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.PopulationMapper;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Service.PopulationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PopulationController is a REST controller that handles HTTP requests related to the Population entity.
 * It extends the SlugableController and provides CRUD operations for Population entities.
 * This controller uses the PopulationService to interact with the database and perform operations on Population entities.
 *
 * The PopulationController class is parameterized with the following types:
 * - Population: The entity type that this controller handles.
 * - PopulationRepository: The repository type used for accessing the database.
 * - PopulationInput: The DTO type used for creating and updating populations.
 * - PopulationMapper: The mapper type used for converting between entities and DTOs.
 * - PopulationService: The service type used for business logic operations.
 */
@Controller
@RequestMapping(path = "/api/v1/population")
@Tag(name = "Population", description = "Endpoints for managing populations")
public class PopulationController extends SlugableController<Population, PopulationRepository, PopulationInput, PopulationMapper, PopulationService> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public PopulationController(PopulationService service, PopulationMapper mapper) {
        super(service, mapper);
    }
}