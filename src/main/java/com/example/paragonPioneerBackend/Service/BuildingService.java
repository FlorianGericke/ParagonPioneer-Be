package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.BuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.PopulationBuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.ProductionBuildingInput;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import com.example.paragonPioneerBackend.Exception.CastException;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.generic.SlugableService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Service class for managing building-related operations in the application.
 * This class extends the generic BaseService to provide specialized functionality
 * for handling operations related to Building entities, including PopulationBuilding
 * and ProductionBuilding subtypes.
 *
 * @param <BuildingTypeDTO> A generic type parameter that extends BuildingDTO,
 *                          allowing the service to work with different types of building DTOs.
 */
@org.springframework.stereotype.Service()
public class BuildingService<BuildingTypeDTO extends BuildingInput> extends SlugableService<Building, BuildingRepository, BuildingTypeDTO> {
    private final RecipeRepository recipeRepository;

    /**
     * Autowired constructor to inject repository dependencies.
     *
     * @param repository         General repository for Building entities.
     * @param buildingRepository Specific repository for Building entities.
     * @param recipeRepository   Repository for managing Recipe entities related to ProductionBuildings.
     */
    @Autowired
    public BuildingService(BuildingRepository repository, BuildingRepository buildingRepository,
                           RecipeRepository recipeRepository) {
        super(repository);
        this.recipeRepository = recipeRepository;
    }

    /**
     * This method is used to map a BuildingTypeDTO to a Building entity.
     * It checks if the DTO is an instance of ProductionBuildingInput or PopulationBuildingInput.
     * If the DTO is an instance of ProductionBuildingInput, it creates a new ProductionBuilding entity with the properties from the DTO.
     * The recipe for the ProductionBuilding is retrieved from the repository using either the UUID or the slug from the DTO.
     * If the DTO is an instance of PopulationBuildingInput, it creates a new PopulationBuilding entity with the properties from the DTO.
     * If the DTO is not an instance of either ProductionBuildingInput or PopulationBuildingInput, it throws a CastException.
     *
     * @param buildingTypeDTO The DTO that contains the new values for the Building entity.
     * @return The newly created Building entity.
     * @throws CastException           if the DTO does not match any known building types.
     * @throws EntityNotFoundException if the recipe for the ProductionBuilding is not found in the repository.
     */
    @Override
    public Building mapToEntity(BuildingTypeDTO buildingTypeDTO) throws CastException {
        if (buildingTypeDTO instanceof ProductionBuildingInput productionBuildingInput) {
            var re = ProductionBuilding.builder()
                    .name(productionBuildingInput.getName())
                    .remarks(productionBuildingInput.getRemarks())
                    .productionPerMinute(productionBuildingInput.getProductionPerMinute())
                    .recipe(ServiceUtil.getHelper(productionBuildingInput.getRecipe(), recipeRepository))
                    .slug(SlugUtil.createSlug(productionBuildingInput.getName()))
                    .build();
            return re;
        }
        if (buildingTypeDTO instanceof PopulationBuildingInput populationBuildingInput) {
            return PopulationBuilding.builder()
                    .name(populationBuildingInput.getName())
                    .remarks(populationBuildingInput.getRemarks())
                    .capacity(populationBuildingInput.getCapacity())
                    .slug(SlugUtil.createSlug(populationBuildingInput.getName()))
                    .build();
        }
        throw new CastException("No Matching Building Type Found");
    }

    /**
     * This method is used to update the properties of a Building entity based on the provided DTO.
     * It checks if the DTO and the entity to update are instances of ProductionBuildingDTO and ProductionBuilding respectively.
     * If true, it updates the name, remarks, production per minute, and recipe of the production building.
     * If the DTO and the entity to update are instances of PopulationBuildingDTO and PopulationBuilding respectively,
     * it updates the name, remarks, and capacity of the population building.
     * If neither condition is met, it throws a CastException.
     *
     * @param entityToUpdate The original Building entity that might be updated.
     * @param dto            The DTO that contains the new values for the Building entity.
     * @return The updated Building entity.
     * @throws CastException if the DTO and the entity to update do not match any known building types.
     */
    @Override
    public Building patch(Building entityToUpdate, BuildingTypeDTO dto) throws CastException {
        if (dto instanceof ProductionBuildingInput productionBuildingDTO && entityToUpdate instanceof ProductionBuilding productionBuilding) {
            productionBuilding.setName(ServiceUtil.patchHelper(productionBuilding.getName(), productionBuildingDTO.getName()));
            productionBuilding.setRemarks(ServiceUtil.patchHelper(productionBuilding.getRemarks(), productionBuildingDTO.getRemarks()));
            productionBuilding.setProductionPerMinute(ServiceUtil.patchHelper(productionBuilding.getProductionPerMinute(), productionBuildingDTO.getProductionPerMinute()));
            productionBuilding.setRecipe(ServiceUtil.patchHelper(productionBuilding.getRecipe(), productionBuildingDTO.getRecipe(), recipeRepository));
            return productionBuilding;
        }
        if (dto instanceof PopulationBuildingInput populationBuildingDTO && entityToUpdate instanceof PopulationBuilding populationBuilding) {
            populationBuilding.setName(ServiceUtil.patchHelper(populationBuilding.getName(), populationBuildingDTO.getName()));
            populationBuilding.setRemarks(ServiceUtil.patchHelper(populationBuilding.getRemarks(), populationBuildingDTO.getRemarks()));
            populationBuilding.setCapacity(ServiceUtil.patchHelper(populationBuilding.getCapacity(), populationBuildingDTO.getCapacity()));
            return populationBuilding;
        }
        throw new CastException("No Matching Building Type Found");
    }

    /**
     * Retrieves all ProductionBuilding entities.
     *
     * @return A list of all ProductionBuilding entities.
     */
    public Page<ProductionBuilding> getAllProductionBuilding(Pageable pageable) {
        return repository.findAllProductionBuildings(pageable);
    }

    /**
     * Retrieves all PopulationBuilding entities.
     *
     * @return A list of all PopulationBuilding entities.
     */
    public Page<PopulationBuilding> getAllPopulationBuilding(Pageable pageable) {
        return repository.findAllPopulationBuildings(pageable);
    }

    /**
     * Searches for a ProductionBuilding entity that has a recipe with the specified name.
     * This method is particularly useful for retrieving specific production buildings
     * when the exact recipe name is known, facilitating operations like data validation, lookup,
     * or display in user interfaces.
     *
     * @param recipeSlug The Slug name of the recipe associated with the production building to find.
     * @return An Optional containing the found production building if available;
     * otherwise, an empty Optional.
     */
    public ProductionBuilding getProductionBuildingByRecipeSlug(String recipeSlug) throws EntityNotFoundException {
        return repository.findProductionBuildingByRecipeSlug(recipeSlug).orElseThrow(() -> new EntityNotFoundException("Building", recipeSlug));
    }
}