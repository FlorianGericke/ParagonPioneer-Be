package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for {@link Recipe} entities. Provides standard CRUD operations inherited
 * from JpaRepository, along with custom query methods to find recipes by their output or the name of their output.
 * This repository plays a crucial role in managing the data access layer for recipe entities, facilitating
 * the retrieval of recipes based on specific criteria related to the product they generate.
 */
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    /**
     * Finds a recipe by its output good.
     *
     * @param output The output {@link Good} of the recipe to find.
     * @return An Optional containing the recipe if a matching output is found; otherwise, an empty Optional.
     */
    Optional<Recipe> findByOutputIs(Good output);

    /**
     * Finds a recipe by the name of its output good.
     *
     * @param outputName The name of the output good of the recipe to find.
     * @return An Optional containing the recipe if a matching output name is found; otherwise, an empty Optional.
     */
    Optional<Recipe> findByOutputNameIs(String outputName);

    /**
     * Finds all recipes where the name of the output good contains the specified substring.
     * This method is particularly useful for implementing search functionalities within the application,
     * allowing users to find recipes based on partial names of the product they are looking to produce.
     *
     * @param outputName The substring to search for within the names of the output goods.
     * @return A list of recipes that contain the specified substring in the name of their output goods.
     */
    List<Recipe> findAllByOutputNameContains(String outputName);
}
