package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.SlugableController;
import com.example.paragonPioneerBackend.Dto.requests.GoodInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.GoodMapper;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Service.GoodService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * GoodController is a REST controller that handles HTTP requests related to the Good entity.
 * It extends the SlugableController and provides CRUD operations for Good entities.
 * This controller uses the GoodService to interact with the database and perform operations on Good entities.
 *
 * The GoodController class is parameterized with the following types:
 * - Good: The entity type that this controller handles.
 * - GoodRepository: The repository type used for accessing the database.
 * - GoodInput: The DTO type used for creating and updating goods.
 * - GoodMapper: The mapper type used for converting between entities and DTOs.
 * - GoodService: The service type used for business logic operations.
 */
@Controller
@RequestMapping(path = "/api/v1/good")
@Tag(name = "Good", description = "Endpoints for managing goods")
public class GoodController extends SlugableController<Good, GoodRepository, GoodInput, GoodMapper, GoodService> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public GoodController(GoodService service, GoodMapper mapper) {
        super(service, mapper);
    }
}