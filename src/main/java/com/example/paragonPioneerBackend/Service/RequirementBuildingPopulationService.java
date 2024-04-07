package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.RequirementPopulationBuildingInput;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Repository.RequirementPopulationBuildingRepository;
import com.example.paragonPioneerBackend.Service.generic.BaseService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing relationships between buildings and their required populations.
 * It facilitates CRUD operations on Requirement_Population_Building entities, leveraging
 * Requirement_Population_BuildingRepository for database interactions. Additionally, it
 * utilizes PopulationRepository and BuildingRepository for operations related to Population
 * and Building entities that are part of these relationships.
 */
@org.springframework.stereotype.Service()
public class RequirementBuildingPopulationService extends BaseService<RequirementPopulationBuilding, RequirementPopulationBuildingRepository, RequirementPopulationBuildingInput> {

    private final PopulationRepository populationRepository;
    private final BuildingRepository buildingRepository;

    /**
     * Autowires the necessary repositories for managing relationships between buildings
     * and population requirements, providing database access for CRUD operations.
     *
     * @param repository           The Requirement_Population_BuildingRepository for database operations on requirement relations.
     * @param populationRepository The PopulationRepository for accessing Population entities.
     * @param buildingRepository   The BuildingRepository for accessing Building entities.
     */
    @Autowired
    public RequirementBuildingPopulationService(RequirementPopulationBuildingRepository repository, PopulationRepository populationRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.populationRepository = populationRepository;
        this.buildingRepository = buildingRepository;
    }

    /**
     * This method is used to map a RequirementPopulationBuildingInput DTO to a RequirementPopulationBuilding entity.
     * It uses the builder pattern to create a new RequirementPopulationBuilding entity and sets its population, building, and amount properties based on the DTO.
     * The population and building are retrieved from the PopulationRepository and BuildingRepository respectively using the PatchUtil.getHelper method.
     *
     * @param requirementPopulationBuildingInput The DTO that contains the new values for the RequirementPopulationBuilding entity.
     * @return The newly created RequirementPopulationBuilding entity.
     */
    @Override
    @Transactional
    public RequirementPopulationBuilding mapToEntity(RequirementPopulationBuildingInput requirementPopulationBuildingInput) {
        return RequirementPopulationBuilding.builder()
                .population(ServiceUtil.getHelper(requirementPopulationBuildingInput.getPopulation(), populationRepository))
                .building(ServiceUtil.getHelper(requirementPopulationBuildingInput.getBuilding(), buildingRepository))
                .amount(requirementPopulationBuildingInput.getAmount())
                .build();
    }

    /**
     * This method is used to update the properties of a RequirementPopulationBuilding entity based on the provided DTO.
     * It updates the building, population, and amount properties of the entity to update.
     * The building and population properties are updated using the PatchUtil.patchHelper method, which checks if the new value is null.
     * If the new value is not null, it replaces the old value. If it is null, the old value is kept.
     * The amount property is directly updated from the DTO.
     * The method is marked as @Transactional, meaning it is part of a database transaction.
     *
     * @param entityToUpdate                     The original RequirementPopulationBuilding entity that might be updated.
     * @param requirementPopulationBuildingInput The DTO that contains the new values for the RequirementPopulationBuilding entity.
     * @return The updated RequirementPopulationBuilding entity.
     */
    @Override
    @Transactional
    public RequirementPopulationBuilding patch(RequirementPopulationBuilding entityToUpdate, RequirementPopulationBuildingInput requirementPopulationBuildingInput) {
        entityToUpdate.setBuilding(ServiceUtil.patchHelper(entityToUpdate.getBuilding(), requirementPopulationBuildingInput.getBuilding(), buildingRepository));
        entityToUpdate.setPopulation(ServiceUtil.patchHelper(entityToUpdate.getPopulation(), requirementPopulationBuildingInput.getPopulation(), populationRepository));
        entityToUpdate.setAmount(ServiceUtil.patchHelper(entityToUpdate.getAmount(), requirementPopulationBuildingInput.getAmount()));
        return entityToUpdate;
    }
}