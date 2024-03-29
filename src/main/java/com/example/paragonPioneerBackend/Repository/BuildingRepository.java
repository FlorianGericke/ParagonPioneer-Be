package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

/**
 * Spring Data JPA repository for {@link Building} entities.
 * This interface provides automated CRUD functionalities inherited from JpaRepository,
 * along with custom methods for querying buildings by their type.
 * It simplifies the management of building data by abstracting direct database interactions,
 * enabling straightforward data access and manipulation.
 */
public interface BuildingRepository extends SlugableReposetory<Building> {

    /**
     * This method is used to find all Buildings that are of type 'PopulationBuilding'.
     * It is a part of the BuildingRepository interface, which extends {}SlugableReposetory.
     * The implementation of this method is provided by Spring Data JPA.
     * The method returns a Set of ProductionBuilding entities that match the criteria.
     * If no Building with a dtype of 'PopulationBuilding' is found, an empty Set is returned.
     *
     * @return A Set of ProductionBuilding entities where the dtype is 'PopulationBuilding'.
     */
    @Query("SELECT p FROM ProductionBuilding p")
    Set<ProductionBuilding> findAllProductionBuildings();

    /**
     * This method is used to find all Buildings that are of type 'PopulationBuilding'.
     * It is a part of the BuildingRepository interface, which extends SlugableReposetory.
     * The implementation of this method is provided by Spring Data JPA.
     * The method returns a Set of PopulationBuilding entities that match the criteria.
     * If no Building with a dtype of 'PopulationBuilding' is found, an empty Set is returned.
     *
     * @return A Set of PopulationBuilding entities where the dtype is 'PopulationBuilding'.
     */
    @Query("SELECT p FROM PopulationBuilding p")
    Set<PopulationBuilding> findAllPopulationBuildings();

    /**
     * This method is used to find a Building that is of type 'PopulationBuilding' by its recipe slug.
     * It is a part of the BuildingRepository interface, which extends SlugableReposetory.
     * The implementation of this method is provided by Spring Data JPA.
     * The method returns an Optional of PopulationBuilding entity that matches the criteria.
     * If no Building with a dtype of 'PopulationBuilding' and the specified recipe slug is found,
     * an empty Optional is returned.
     *
     * @param recipeSlug The slug of the recipe associated with the PopulationBuilding.
     * @return An Optional of PopulationBuilding entity where the dtype is 'PopulationBuilding' and the recipe slug matches.
     */
    @Query("SELECT p FROM ProductionBuilding p  WHERE p.recipe.output.slug = :recipeSlug")
    Optional<ProductionBuilding> findProductionBuildingByRecipeSlug(@Param("recipeSlug") String recipeSlug);
}
