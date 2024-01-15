package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.RecipeDTO;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handling all endpoints responding to recipes, extends BaseController.
 *
 */
@RestController
@RequestMapping(path = "/api/v1/recipe")
public class RecipeController extends BaseController<Recipe, RecipeRepository, RecipeDTO, RecipeService> {

    /**
     * Constructor for RecipeController, gets autowired
     * @param service service the controller is using
     */
    @Autowired
    public RecipeController(RecipeService service) {
        super(service);
    }
}