package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;

import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for {@link Recipe} entities. Provides standard CRUD operations inherited
 * from JpaRepository, along with custom query methods to find recipes by their output or the name of their output.
 * This repository plays a crucial role in managing the data access layer for recipe entities, facilitating
 * the retrieval of recipes based on specific criteria related to the product they generate.
 */
public interface RecipeRepository extends SlugableReposetory<Recipe> {

    /**
     * Finds a recipe by its output good.
     *
     * @param output The output {@link Good} of the recipe to find.
     * @return An Optional containing the recipe if a matching output is found; otherwise, an empty Optional.
     */
    Optional<Recipe> findByOutputIs(Good output);

    /**
     * Finds a recipe by its output good's ID.
     *
     * @param id The UUID of the output {@link Good} of the recipe to find.
     * @return An Optional containing the recipe if a matching output ID is found; otherwise, an empty Optional.
     */
    Optional<Recipe> findByOutputIdIs(UUID id);
}
