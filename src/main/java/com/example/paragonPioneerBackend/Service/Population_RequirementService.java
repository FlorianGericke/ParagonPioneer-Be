package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Population_RequirementDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Population_Requirement;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Repository.Population_RequirementRepository;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service class responsible for managing relationships between populations and their requirements.
 * This class extends the generic BaseService to provide specific CRUD operations for Population_Requirement entities.
 * It leverages Population_RequirementDTO for data transfer and interacts with Population_RequirementRepository for persistence operations.
 */
@Service(value = "population_RequirementService")
public class Population_RequirementService extends BaseService<Population_Requirement, Population_RequirementRepository, Population_RequirementDTO> {

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
    public Population_RequirementService(Population_RequirementRepository repository, GoodRepository goodRepository, PopulationRepository populationRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.populationRepository = populationRepository;
    }

    /**
     * Creates and saves a new population requirement relationship in the database based on the provided DTO.
     *
     * @param populationRequirementDTO Data Transfer Object containing the data for the new relationship.
     * @return The newly created and persisted Population_Requirement entity.
     */
    @Override
    public Population_Requirement post(Population_RequirementDTO populationRequirementDTO) {
        return repository.save(Population_Requirement.builder()
                .population(UuidUtil.parseUuidFromStringOrNull(populationRequirementDTO.getPopulationId()) == null ?
                        null :
                        populationRepository.findById(UuidUtil.parseUuidFromStringOrNull(populationRequirementDTO.getPopulationId())).orElse(null))
                .good(UuidUtil.parseUuidFromStringOrNull(populationRequirementDTO.getGoodId()) == null ?
                        null :
                        goodRepository.findById(UuidUtil.parseUuidFromStringOrNull(populationRequirementDTO.getGoodId())).orElse(null))
                .produce(populationRequirementDTO.getProduce())
                .consumption(populationRequirementDTO.getConsumption())
                .isBasic(populationRequirementDTO.isBasic())
                .build());
    }

    /**
     * Updates an existing Population_Requirement entity with data from the provided DTO.
     *
     * @param original                 The original entity to be updated.
     * @param populationRequirementDTO DTO containing the new data for the entity.
     * @return The updated Population_Requirement entity.
     */
    @Override
    public Population_Requirement putPatch(Population_Requirement original, Population_RequirementDTO populationRequirementDTO) throws EntityNotFoundException {
        original.setPopulation(populationRequirementDTO.getPopulationId() == null ?
                original.getPopulation() :
                populationRepository.findById(UUID.fromString(populationRequirementDTO.getPopulationId())).get());
        original.setGood(populationRequirementDTO.getGoodId() == null ?
                original.getGood() :
                goodRepository.findById(UUID.fromString(populationRequirementDTO.getGoodId())).get());
        if (original.getProduce() != populationRequirementDTO.getProduce()) {
            original.setProduce(populationRequirementDTO.getProduce());
        }
        if (original.isBasic() != populationRequirementDTO.isBasic()) {
            original.setBasic(populationRequirementDTO.isBasic());
        }
        return original;
    }
}
