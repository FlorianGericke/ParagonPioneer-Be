package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Dto.PopulationBuildingDTO;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.PopulationBuildingRepository;
import com.example.paragonPioneerBackend.Repository.ProductionBuildingRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Service class for managing building-related operations in the application.
 * This class extends the generic BaseService to provide specialized functionality
 * for handling operations related to Building entities, including PopulationBuilding
 * and ProductionBuilding subtypes.
 *
 * @param <BuildingTypeDTO> A generic type parameter that extends BuildingDTO,
 *                          allowing the service to work with different types of building DTOs.
 */
@Service(value = "buildingService")
public class BuildingService<BuildingTypeDTO extends BuildingDTO> extends BaseService<Building, BuildingRepository, BuildingTypeDTO> {

    private final BuildingRepository buildingRepository;
    private final PopulationBuildingRepository populationBuildingRepository;
    private final ProductionBuildingRepository productionBuildingRepository;
    private final RecipeRepository recipeRepository;

    /**
     * Autowired constructor to inject repository dependencies.
     *
     * @param repository                   General repository for Building entities.
     * @param buildingRepository           Specific repository for Building entities.
     * @param populationBuildingRepository Repository for PopulationBuilding entities.
     * @param productionBuildingRepository Repository for ProductionBuilding entities.
     * @param recipeRepository             Repository for managing Recipe entities related to ProductionBuildings.
     */
    @Autowired
    public BuildingService(BuildingRepository repository, BuildingRepository buildingRepository,
                           PopulationBuildingRepository populationBuildingRepository,
                           ProductionBuildingRepository productionBuildingRepository,
                           RecipeRepository recipeRepository) {
        super(repository);
        this.buildingRepository = buildingRepository;
        this.populationBuildingRepository = populationBuildingRepository;
        this.productionBuildingRepository = productionBuildingRepository;
        this.recipeRepository = recipeRepository;
    }

    /**
     * Searches for a building entity by its slug.
     *
     * @param slug The slug to search for.
     * @return An Optional containing the Building entity if found, or empty otherwise.
     */
    public Optional<Building> findBySlug(String slug) {
        return repository.findBySlugIs(slug);
    }

    /**
     * Retrieves all building entities that contain the specified name.
     *
     * @param name The name to search for.
     * @return A list of Building entities that contain the given name.
     */
    public List<Building> findAllByNameContains(String name) {
        return repository.findAllByNameContains(name);
    }

    /**
     * Searches for a building entity by its name.
     *
     * @param name The name to search for.
     * @return An Optional containing the Building entity if found, or empty otherwise.
     */
    public Optional<Building> findByName(String name) {
        return repository.findByNameIs(name);
    }

    /**
     * Adds a new building entity to the database based on the provided DTO.
     *
     * @param buildingTypeDTO The DTO containing the data for the new building entity.
     * @return The newly added Building entity.
     */
    @Override
    public Building post(BuildingTypeDTO buildingTypeDTO) {
        if (buildingTypeDTO instanceof PopulationBuildingDTO populationBuildingDTO) {
            return buildingRepository.save(PopulationBuilding.builder()
                    .name(populationBuildingDTO.getName())
                    .remarks(populationBuildingDTO.getRemarks())
                    .capacity(populationBuildingDTO.getCapacity())
                    .slug(populationBuildingDTO.getSlug().isEmpty() ? SlugUtil.createSlug(populationBuildingDTO.getName()) : populationBuildingDTO.getSlug())
                    .build());
        }
        if (buildingTypeDTO instanceof ProductionBuildingDTO productionBuildingDTO) {
            ProductionBuilding building = ProductionBuilding.builder()
                    .name(productionBuildingDTO.getName())
                    .remarks(productionBuildingDTO.getRemarks())
                    .productionPerMinute(productionBuildingDTO.getProductionPerMinute())
                    .recipe(UuidUtil.parseUuidFromStringOrNull(productionBuildingDTO.getIdOfRecipe()) == null ?
                            null :
                            recipeRepository.findById(UuidUtil.parseUuidFromStringOrNull(productionBuildingDTO.getIdOfRecipe())).orElse(null))
                    .slug(productionBuildingDTO.getSlug().isEmpty() ? SlugUtil.createSlug(productionBuildingDTO.getName()) : productionBuildingDTO.getSlug())
                    .build();
            return buildingRepository.save(building);
        }

        return null;
    }

    /**
     * Updates an existing building entity with the data provided in the DTO.
     *
     * @param original        The original building entity to be updated.
     * @param buildingTypeDTO The DTO containing the updated data.
     * @return The updated Building entity.
     */
    @Override
    public Building putPatch(Building original, BuildingTypeDTO buildingTypeDTO) {
        original.setName(buildingTypeDTO.getName() != null ? buildingTypeDTO.getName() : original.getName());
        original.setRemarks(buildingTypeDTO.getRemarks() != null ? buildingTypeDTO.getRemarks() : original.getRemarks());
        original.setSlug(buildingTypeDTO.getSlug() != null ? buildingTypeDTO.getSlug() : original.getSlug());

        if (buildingTypeDTO instanceof PopulationBuildingDTO populationBuildingDTO && original instanceof PopulationBuilding) {
            ((PopulationBuilding) original).setCapacity(populationBuildingDTO.getCapacity() != ((PopulationBuilding) original).getCapacity() ? populationBuildingDTO.getCapacity() : ((PopulationBuilding) original).getCapacity());
            return original;
        }

        if (buildingTypeDTO instanceof ProductionBuildingDTO productionBuildingDTO && original instanceof ProductionBuilding) {
            ((ProductionBuilding) original).setProductionPerMinute(productionBuildingDTO.getProductionPerMinute() != ((ProductionBuilding) original).getProductionPerMinute() ? productionBuildingDTO.getProductionPerMinute() : ((ProductionBuilding) original).getProductionPerMinute());
            ((ProductionBuilding) original).setRecipe(productionBuildingDTO.getIdOfRecipe() != null ? recipeRepository.findById(UUID.fromString(productionBuildingDTO.getIdOfRecipe())).get() : ((ProductionBuilding) original).getRecipe());
            return original;
        }

        return null;
    }

    /**
     * Retrieves all ProductionBuilding entities.
     *
     * @return A list of all ProductionBuilding entities.
     */
    public List<ProductionBuilding> getAllProductionBuilding() {
        return productionBuildingRepository.findAll();
    }

    /**
     * Retrieves all PopulationBuilding entities.
     *
     * @return A list of all PopulationBuilding entities.
     */
    public List<PopulationBuilding> getAllPopulationBuilding() {
        return populationBuildingRepository.findAll();
    }
}
