package com.example.paragonPioneerBackend.Service.EntityServices;

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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * the Base handling the CRUD functions for the Building Entities. Extends BaseService
 *
 * @param <BuildingTypeDTO> The DTO the Service should use
 */
@Service(value = "buildingService")
public class BuildingService<BuildingTypeDTO extends BuildingDTO> extends BaseService<Building, BuildingRepository, BuildingTypeDTO> {

    private final BuildingRepository buildingRepository;
    private final PopulationBuildingRepository populationBuildingRepository;
    private final ProductionBuildingRepository productionBuildingRepository;
    private final RecipeRepository recipeRepository;

    /**
     * Constructs a new BuildingService. is Autowired
     *
     * @param repository                   the repository the Service should use
     * @param buildingRepository           the repository the Service should use
     * @param populationBuildingRepository the repository the Service should use
     * @param productionBuildingRepository the repository the Service should use
     * @param recipeRepository             the repository the Service should use
     */
    @Autowired
    public BuildingService(BuildingRepository repository, BuildingRepository buildingRepository, PopulationBuildingRepository populationBuildingRepository, ProductionBuildingRepository productionBuildingRepository, RecipeRepository recipeRepository) {
        super(repository);
        this.buildingRepository = buildingRepository;
        this.populationBuildingRepository = populationBuildingRepository;
        this.productionBuildingRepository = productionBuildingRepository;
        this.recipeRepository = recipeRepository;
    }

    /**
     * Find Good by slug
     *
     * @param slug the string contained
     * @return list of Goods matching
     */
    public Optional<Building> findBySlug(String slug) {
        return repository.findBySlugIs(slug);
    }

    /**
     * Find all Buildings with name contains
     *
     * @param name the string contained
     * @return list of Recipe matching
     */
    public List<Building> findAllByNameContains(String name) {
        return repository.findAllByNameContains(name);
    }

    /**
     * Find Good by Name
     *
     * @param name the string contained
     * @return list of Goods matching
     */
    public Optional<Building> findByName(String name) {
        return repository.findByNameIs(name);
    }

    /**
     * Adds new Entity to the database
     * Overridden from BaseService
     *
     * @param buildingTypeDTO DTO responding to the Entity to add.
     * @return the added entity
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
            try {
                return buildingRepository.save(building);
            } catch (Exception e) {

                throw new RuntimeException(e.getMessage() +"\n"+ String.valueOf(productionBuildingDTO) +"\n"+ building);
            }

        }

        return null;
    }

    /**
     * Updates an Entity
     * Overridden from BaseService
     *
     * @param original        original entity
     * @param buildingTypeDTO dto containing the updated data
     * @return the updated entity
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
     * get all ProductionBuildings
     *
     * @return List of all ProductionBuildings
     */
    public List<ProductionBuilding> getAllProductionBuilding() {
        return productionBuildingRepository.findAll();
    }

    /**
     * get all PopulationBuildings
     *
     * @return List of all PopulationBuildings
     */
    public List<PopulationBuilding> getAlPopulationBuilding() {
        return populationBuildingRepository.findAll();
    }
}
