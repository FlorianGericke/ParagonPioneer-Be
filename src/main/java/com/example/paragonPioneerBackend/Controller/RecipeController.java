package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.RecipeDTO;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Handling all endpoints responding to recipes, extends BaseController.
 */
@Controller
@RequestMapping(path = "/api/v1/recipe")
public class RecipeController extends BaseController<Recipe, RecipeRepository, RecipeDTO, RecipeService> {

    /**
     * Constructor for RecipeController, gets autowired
     *
     * @param service service the controller is using
     */
    @Autowired
    public RecipeController(RecipeService service) {
        super(service);
    }

    /**
     * get endpoint for find by outputName
     *
     * @param outputName to look for
     * @return list of all Recipe containing the name
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Recipe> getEntities(@RequestParam String outputName) {
        return service.findAllByNameContains(outputName);
    }

    @GetMapping(path = "/output/{id}", produces = "application/json")
    public @ResponseBody Optional<Recipe> getEntity(@PathVariable UUID id) {
        return service.findAllByOutputId(id);
    }
}