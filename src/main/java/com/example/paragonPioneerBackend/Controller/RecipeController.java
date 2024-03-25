package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.RecipeDTO;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller for managing HTTP requests related to Recipe entities.
 * Inherits from BaseController to provide common CRUD operations for Recipe entities
 * and extends functionality to include searching by output product name and retrieving
 * by output product ID.
 * Leverages RecipeService for business logic and data persistence.
 */
@Controller
@RequestMapping(path = "/api/v1/recipe")
public class RecipeController extends BaseController<Recipe, RecipeRepository, RecipeDTO, RecipeService> {

    /**
     * Autowired constructor to inject RecipeService into this controller.
     * Utilizes the injected service to handle business logic associated with recipes.
     *
     * @param service The RecipeService instance for managing recipes.
     */
    @Autowired
    public RecipeController(RecipeService service) {
        super(service);
    }

    /**
     * Retrieves a list of recipes whose output product's name contains the specified substring.
     * This method facilitates the search functionality, allowing users to find recipes based on
     * partial names of the output product.
     *
     * @param outputName The substring to search for within the output product's name.
     * @return A list of recipes that match the search criteria.
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Recipe> getEntities(@RequestParam String outputName) {
        return service.findAllByNameContains(outputName);
    }

    /**
     * Retrieves a specific recipe based on the output product's UUID.
     * This endpoint allows for direct lookup of a recipe by associating it with
     * the unique identifier of its output product.
     *
     * @param id The UUID of the output product.
     * @return An Optional containing the found recipe if available, or empty otherwise.
     */
    @GetMapping(path = "/output/{id}", produces = "application/json")
    public @ResponseBody Recipe getEntity(@PathVariable UUID id) {
        return service.findAllByOutputId(id);
    }
}
