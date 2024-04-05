package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.PopulationRequirementInput;
import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Repository.PopulationRequirementRepository;
import com.example.paragonPioneerBackend.Service.generic.BaseService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing population requirement relations within the application.
 * This class extends the generic BaseService to provide specialized CRUD operations for PopulationRequirement entities.
 * It interacts with the GoodRepository and PopulationRepository to handle operations related to goods and populations.
 */
@org.springframework.stereotype.Service()
public class PopulationRequirementService extends BaseService<PopulationRequirement, PopulationRequirementRepository, PopulationRequirementInput> {

    private final GoodRepository goodRepository;
    private final PopulationRepository populationRepository;

    /**
     * Autowired constructor initializing the service with necessary repositories for interaction with database.
     *
     * @param repository           Population_RequirementRepository instance for handling population requirement data.
     * @param goodRepository       GoodRepository instance for accessing good-related data.
     * @param populationRepository PopulationRepository instance for accessing population-related data.
     */
    @Autowired
    public PopulationRequirementService(PopulationRequirementRepository repository, GoodRepository goodRepository, PopulationRepository populationRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.populationRepository = populationRepository;
    }

    /**
     * This method is used to map a PopulationRequirementInput DTO to a PopulationRequirement entity.
     * It uses the builder pattern to create a new PopulationRequirement entity and sets its properties based on the DTO.
     * The good and population properties are retrieved from their respective repositories using the PatchUtil.getHelper method.
     * The consumption, produce rate, and isBasic properties are set directly from the DTO.
     *
     * @param populationRequirementDTO The DTO that contains the new values for the PopulationRequirement entity.
     * @return The newly created PopulationRequirement entity.
     */
    @Override
    @Transactional
    public PopulationRequirement mapToEntity(PopulationRequirementInput populationRequirementDTO) {
        return PopulationRequirement.builder()
                .good(ServiceUtil.ifErrorThenNull(good ->ServiceUtil.getHelper(good, goodRepository),populationRequirementDTO.getGood()))
                .population(ServiceUtil.ifErrorThenNull(population->ServiceUtil.getHelper(population, populationRepository),populationRequirementDTO.getPopulation()))
                .consumption(populationRequirementDTO.getConsumption())
                .produce(populationRequirementDTO.getProduceRate())
                .isBasic(populationRequirementDTO.isBasic())
                .build();
    }

    /**
     * This method is used to update the properties of a PopulationRequirement entity based on the provided DTO.
     * It updates the good, population, consumption, produce rate, and isBasic properties of the entity to update.
     * The good and population are updated using the PatchUtil.patchHelper method, which checks if the new value is null.
     * If the new value is not null, it replaces the old value. If it is null, the old value is kept.
     * The consumption, produce rate, and isBasic properties are updated directly from the DTO.
     * The method is marked as @Transactional, meaning it is part of a database transaction.
     *
     * @param entityToUpdate           The original PopulationRequirement entity that might be updated.
     * @param populationRequirementDTO The DTO that contains the new values for the PopulationRequirement entity.
     * @return The updated PopulationRequirement entity. Currently, it returns null which might be a mistake or placeholder.
     */
    @Override
    @Transactional
    public PopulationRequirement patch(PopulationRequirement entityToUpdate, PopulationRequirementInput populationRequirementDTO) {
        entityToUpdate.setGood(ServiceUtil.patchHelper(entityToUpdate.getGood(), populationRequirementDTO.getGood(), goodRepository));
        entityToUpdate.setPopulation(ServiceUtil.patchHelper(entityToUpdate.getPopulation(), populationRequirementDTO.getPopulation(), populationRepository));
        entityToUpdate.setConsumption(ServiceUtil.patchHelper(entityToUpdate.getConsumption(), populationRequirementDTO.getConsumption()));
        entityToUpdate.setProduce(ServiceUtil.patchHelper(entityToUpdate.getProduce(), populationRequirementDTO.getProduceRate()));
        entityToUpdate.setBasic(ServiceUtil.patchHelper(entityToUpdate.isBasic(), populationRequirementDTO.isBasic()));
        return null;
    }
}