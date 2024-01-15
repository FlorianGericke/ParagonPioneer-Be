package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for the recipes
 */
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    /**
     * * find a populationBuilding by its output
     * @param output the output good of the recipe  to find
     * @return the recipe
     */
    Optional<Recipe> findByOutputIs(Good output);

    /**
     * * find a populationBuilding by its output name
     * @param outputName the output good name of the recipe  to find
     * @return the recipe
     */
    Optional<Recipe> findByOutputNameIs(String outputName);
}


