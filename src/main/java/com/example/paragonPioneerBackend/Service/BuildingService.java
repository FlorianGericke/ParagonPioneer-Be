package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.BuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.PopulationBuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.ProductionBuildingInput;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.example.paragonPioneerBackend.Exception.CastException;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.*;
import com.example.paragonPioneerBackend.Service.generic.SlugableService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
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
@org.springframework.stereotype.Service()
public class BuildingService<BuildingTypeDTO extends BuildingInput> extends SlugableService<Building, BuildingRepository, BuildingTypeDTO> {
    private final RecipeRepository recipeRepository;
    private final GoodRepository goodRepository;
    private final CostBuildingGoodsRepository costBuildingGoodsRepository;
    private final RequirementPopulationBuildingRepository requirementPopulationBuildingRepository;
    private final PopulationRepository populationRepository;

    /**
     * Constructor for the BuildingService class.
     * It initializes the BuildingService with the provided repositories.
     * It also calls the superclass's constructor with the BuildingRepository.
     *
     * @param repository                              The BuildingRepository for managing Building entities.
     * @param recipeRepository                        The RecipeRepository for managing Recipe entities.
     * @param goodRepository                          The GoodRepository for managing Good entities.
     * @param costBuildingGoodsRepository             The CostBuildingGoodsRepository for managing CostBuildingGoods entities.
     * @param requirementPopulationBuildingRepository The RequirementPopulationBuildingRepository for managing RequirementPopulationBuilding entities.
     * @param populationRepository                    The PopulationRepository for managing Population entities.
     */
    @Autowired
    public BuildingService(BuildingRepository repository,
                           RecipeRepository recipeRepository,
                           GoodRepository goodRepository,
                           CostBuildingGoodsRepository costBuildingGoodsRepository,
                           RequirementPopulationBuildingRepository requirementPopulationBuildingRepository,
                           PopulationRepository populationRepository) {
        super(repository);
        this.recipeRepository = recipeRepository;
        this.goodRepository = goodRepository;
        this.costBuildingGoodsRepository = costBuildingGoodsRepository;
        this.requirementPopulationBuildingRepository = requirementPopulationBuildingRepository;
        this.populationRepository = populationRepository;
    }

    /**
     * This method is responsible for creating a new Building entity based on the provided BuildingTypeDTO.
     * It first calls the superclass's post method to create a basic Building entity.
     * Then, it sets the 'requirePopulation' field of the Building entity by calling the 'createRequirement' method with the BuildingTypeDTO and the newly created Building entity.
     * It also sets the 'costs' field of the Building entity by calling the 'createCostBuildingGoods' method with the BuildingTypeDTO and the newly created Building entity.
     * Finally, it saves the updated Building entity in the repository and returns it.
     *
     * @param buildingTypeDTO The BuildingTypeDTO object that contains the data for creating the Building entity.
     * @return The created and saved Building entity.
     */
    @Transactional
    @Override
    public Building post(BuildingTypeDTO buildingTypeDTO) {
        var building = super.post(buildingTypeDTO);
        building.setRequirePopulation(createRequirement(buildingTypeDTO, building));
        building.setCosts(createCostBuildingGoods(buildingTypeDTO, building));
        return repository.save(building);
    }

    /**
     * This method is responsible for updating an existing Building entity based on the provided BuildingTypeDTO.
     * It first calls the superclass's put method to update the basic fields of the Building entity.
     * Then, it sets the 'requirePopulation' field of the Building entity by calling the 'createRequirement' method with the BuildingTypeDTO and the updated Building entity.
     * It also sets the 'costs' field of the Building entity by calling the 'createCostBuildingGoods' method with the BuildingTypeDTO and the updated Building entity.
     * Finally, it saves the updated Building entity in the repository and returns it.
     *
     * @param id              The UUID of the Building entity to be updated.
     * @param buildingTypeDTO The BuildingTypeDTO object that contains the data for updating the Building entity.
     * @return The updated and saved Building entity.
     * @throws EntityNotFoundException If no Building entity with the provided UUID is found.
     */
    @Transactional
    @Override
    public Building put(UUID id, BuildingTypeDTO buildingTypeDTO) throws EntityNotFoundException {
        removeRequirement(id);
        removeCosts(id);
        var building = super.put(id, buildingTypeDTO);
        building.setRequirePopulation(createRequirement(buildingTypeDTO, building));
        building.setCosts(createCostBuildingGoods(buildingTypeDTO, building));
        return repository.save(building);
    }

    /**
     * This method is responsible for partially updating an existing Building entity based on the provided BuildingTypeDTO.
     * It first calls the superclass's patch method to update the basic fields of the Building entity.
     * Then, it sets the 'requirePopulation' field of the Building entity by calling the 'createRequirement' method with the BuildingTypeDTO and the updated Building entity.
     * It also sets the 'costs' field of the Building entity by calling the 'createCostBuildingGoods' method with the BuildingTypeDTO and the updated Building entity.
     * Finally, it saves the updated Building entity in the repository and returns it.
     *
     * @param id              The UUID of the Building entity to be updated.
     * @param buildingTypeDTO The BuildingTypeDTO object that contains the data for updating the Building entity.
     * @return The updated and saved Building entity.
     * @throws EntityNotFoundException If no Building entity with the provided UUID is found.
     */
    @Transactional
    @Override
    public Building patch(UUID id, BuildingTypeDTO buildingTypeDTO) throws EntityNotFoundException {
        var building = super.patch(id, buildingTypeDTO);
        building.setRequirePopulation(createRequirement(buildingTypeDTO, building));
        building.setCosts(createCostBuildingGoods(buildingTypeDTO, building));
        return repository.save(building);
    }

    /**
     * This method is responsible for partially updating an existing Building entity based on the provided BuildingTypeDTO.
     * It first checks if the BuildingTypeDTO has a 'require' field. If so, it deletes the existing RequirementPopulationBuilding entity associated with the Building entity and sets the 'requirePopulation' field to null.
     * It then checks if the BuildingTypeDTO has a 'costs' field. If so, it deletes all the existing CostBuildingGoods entities associated with the Building entity and sets the 'requirePopulation' field to null.
     * If the BuildingTypeDTO is an instance of ProductionBuildingInput and the Building entity is an instance of ProductionBuilding, it updates the 'name', 'remarks', 'productionPerMinute', and 'recipe' fields of the ProductionBuilding entity.
     * If the BuildingTypeDTO is an instance of PopulationBuildingInput and the Building entity is an instance of PopulationBuilding, it updates the 'name', 'remarks', and 'capacity' fields of the PopulationBuilding entity.
     * If the BuildingTypeDTO is not an instance of any known subtype, it throws a CastException.
     *
     * @param entityToUpdate The Building entity to be updated.
     * @param dto            The BuildingTypeDTO object that contains the data for updating the Building entity.
     * @return The updated Building entity.
     * @throws CastException If the BuildingTypeDTO is not an instance of any known subtype.
     */
    @Transactional
    @Override
    public Building patch(Building entityToUpdate, BuildingTypeDTO dto) throws CastException {
        if (dto.getRequire() != null) {
            removeRequirement(entityToUpdate);
        }
        if (dto.getCosts() != null && !dto.getCosts().isEmpty()) {
            removeCosts(entityToUpdate);
        }

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
     * This method is responsible for mapping a BuildingTypeDTO object to a Building entity.
     * It checks the type of the BuildingTypeDTO and maps it to the corresponding Building subtype.
     * If the BuildingTypeDTO is an instance of ProductionBuildingInput, it maps it to a ProductionBuilding entity.
     * If the BuildingTypeDTO is an instance of PopulationBuildingInput, it maps it to a PopulationBuilding entity.
     * If the BuildingTypeDTO is not an instance of any known subtype, it throws a CastException.
     *
     * @param buildingTypeDTO The BuildingTypeDTO object to be mapped to a Building entity.
     * @return The mapped Building entity.
     * @throws CastException If the BuildingTypeDTO is not an instance of any known subtype.
     */
    @Override
    @Transactional
    public Building mapToEntity(BuildingTypeDTO buildingTypeDTO) throws CastException {
        // Check if the BuildingTypeDTO is an instance of ProductionBuildingInput
        if (buildingTypeDTO instanceof ProductionBuildingInput productionBuildingInput) {
            // Map the ProductionBuildingInput to a ProductionBuilding entity
            return ProductionBuilding.builder()
                    .remarks(productionBuildingInput.getRemarks())
                    .productionPerMinute(productionBuildingInput.getProductionPerMinute())
                    .recipe((ServiceUtil.ifErrorThenNull(recipe -> ServiceUtil.getHelper(recipe, recipeRepository), productionBuildingInput.getRecipe())))
                    .name(productionBuildingInput.getName())
                    .slug(SlugUtil.createSlug(productionBuildingInput.getName()))
                    .build();
        }
        // Check if the BuildingTypeDTO is an instance of PopulationBuildingInput
        if (buildingTypeDTO instanceof PopulationBuildingInput populationBuildingInput) {
            // Map the PopulationBuildingInput to a PopulationBuilding entity
            return PopulationBuilding.builder()
                    .remarks(populationBuildingInput.getRemarks())
                    .capacity(populationBuildingInput.getCapacity())
                    .name(populationBuildingInput.getName())
                    .slug(SlugUtil.createSlug(populationBuildingInput.getName()))
                    .build();
        }
        // Throw a CastException if the BuildingTypeDTO is not an instance of any known subtype
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

    /**
     * Searches for a PopulationBuilding entity that has a capacity equal to the specified value.
     * This method is particularly useful for retrieving specific population buildings
     * when the exact capacity is known, facilitating operations like data validation, lookup,
     * or display in user interfaces.
     *
     * @param buildingInput The capacity of the population building to find.
     * @return An Optional containing the found population building if available;
     * otherwise, an empty Optional.
     */
    private Set<CostBuildingGoods> createCostBuildingGoods(BuildingInput buildingInput, Building building) {
        if (buildingInput.getCosts() == null) {
            return null;
        }
        Set<CostBuildingGoods> costs = new HashSet<>();
        for (var cost : buildingInput.getCosts()) {
            if (!cost.containsKey("good") || !cost.containsKey("amount")) {
                throw new CastException("Costs must contain 'good' and 'amount' keys");
            }
            var good = ServiceUtil.getHelper(cost.get("good"), goodRepository);
            var amount = cost.get("amount");
            var saved = costBuildingGoodsRepository.save(CostBuildingGoods.builder().building(building).good(good).amount(Integer.parseInt(amount)).build());
            costs.add(costBuildingGoodsRepository.getReferenceById(saved.getId()));
        }
        return costs;
    }

    /**
     * This method is responsible for creating a RequirementPopulationBuilding entity based on the provided BuildingInput.
     * It checks if the BuildingInput has a 'require' field. If not, it returns null.
     * If the 'require' field is present, it checks if it contains 'population' and 'amount' keys. If not, it throws a CastException.
     * It retrieves the population and amount values from the 'require' field, and uses them to create a new RequirementPopulationBuilding entity.
     * The new entity is saved in the requirementPopulationBuildingRepository and returned.
     *
     * @param buildingInput The BuildingInput object that contains the 'require' field.
     * @param building      The Building entity to which the RequirementPopulationBuilding entity is associated.
     * @return The created RequirementPopulationBuilding entity.
     * @throws CastException If the 'require' field does not contain 'population' and 'amount' keys.
     */
    private RequirementPopulationBuilding createRequirement(BuildingInput buildingInput, Building building) {
        // Check if the BuildingInput has a 'require' field
        if (buildingInput.getRequire() == null) {
            return null;
        }
        // Check if the 'require' field contains 'population' and 'amount' keys
        if (!buildingInput.getRequire().containsKey("population") || !buildingInput.getRequire().containsKey("amount")) {
            throw new CastException("Costs must contain 'population' and 'amount' keys");
        }
        // Retrieve the population and amount values from the 'require' field
        var population = ServiceUtil.getHelper(buildingInput.getRequire().get("population"), populationRepository);
        var amount = buildingInput.getRequire().get("amount");
        // Create a new RequirementPopulationBuilding entity and save it in the repository
        var re = requirementPopulationBuildingRepository.save(RequirementPopulationBuilding.builder().building(building).population(population).amount(Integer.parseInt(amount)).build());
        // Return the created RequirementPopulationBuilding entity
        return requirementPopulationBuildingRepository.getReferenceById(re.getId());
    }

    private void removeCosts(Building building) {
        if (building.getCosts() != null) {
            costBuildingGoodsRepository.deleteAll(building.getCosts());
            building.setCosts(null);
            repository.save(building);
        }
    }

    private void removeCosts(UUID id) {
        removeCosts(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Building", id)));
    }

    private void removeRequirement(UUID id) {
        removeRequirement(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Building", id)));
    }


    private void removeRequirement(Building building) {
        if (building.getRequirePopulation() != null) {
            requirementPopulationBuildingRepository.deleteById(building.getRequirePopulation().getId());
            building.setRequirePopulation(null);
            repository.save(building);
        }
    }
}