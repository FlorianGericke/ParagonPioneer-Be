package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.SlugableController;
import com.example.paragonPioneerBackend.Dto.requests.RecipeInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.RecipeMapper;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * RecipeController is a REST controller that handles HTTP requests related to the Recipe entity.
 * It extends the SlugableController and provides CRUD operations for Recipe entities.
 * This controller uses the RecipeService to interact with the database and perform operations on Recipe entities.
 *
 * The RecipeController class is parameterized with the following types:
 * - Recipe: The entity type that this controller handles.
 * - RecipeRepository: The repository type used for accessing the database.
 * - RecipeInput: The DTO type used for creating and updating recipes.
 * - RecipeMapper: The mapper type used for converting between entities and DTOs.
 * - RecipeService: The service type used for business logic operations.
 */
@Controller
@RequestMapping(path = "/api/v1/recipe")
public class RecipeController extends SlugableController<Recipe, RecipeRepository, RecipeInput, RecipeMapper, RecipeService> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public RecipeController(RecipeService service, RecipeMapper mapper) {
        super(service, mapper);
    }

    /**
     * Endpoint to fetch a recipe by its output ID.
     * It uses the service to fetch the recipe and the mapper to map the entity to a response DTO.
     *
     * @param id The output ID of the recipe.
     * @return A RecipeMapper object.
     */
    @GetMapping(value = "/byOutput/{id},", produces = "application/json")
    public RecipeMapper getByOutputId(@PathVariable UUID id) {
        return mapper.map(service.findByOutputId(id));
    }
}