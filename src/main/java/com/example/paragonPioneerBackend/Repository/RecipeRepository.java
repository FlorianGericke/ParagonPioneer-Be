package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for the recipes
 */
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    /**
     * * find a populationBuilding by its output
     *
     * @param output the output good of the recipe  to find
     * @return the recipe
     */
    Recipe findByOutputIs(Good output);

    /**
     * * find a populationBuilding by its output name
     *
     * @param outputName the output good name of the recipe  to find
     * @return the recipe
     */
    Recipe findByOutputNameIs(String outputName);

    /**
     * find all recipes by output name contains
     *
     * @param outputName contained string
     * @return list of all matching
     */
    List<Recipe> findAllByOutputNameContains(String outputName);
}


