package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.PopulationInput;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Exception.OccupiedRelationException;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Repository.PopulationRequirementRepository;
import com.example.paragonPioneerBackend.Service.generic.SlugableService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service for managing populations within the application. It provides functionality to add, retrieve,
 * update, and find populations based on various criteria. This service extends the generic BaseService,
 * specifying Population as the entity type, PopulationRepository as the repository, and PopulationDTO
 * as the data transfer object (DTO).
 */
@org.springframework.stereotype.Service()
public class PopulationService extends SlugableService<Population, PopulationRepository, PopulationInput> {

    private final PopulationRequirementRepository populationRequirementRepository;

    /**
     * Constructor for PopulationService, automatically wired with its repository.
     * Initializes the service with the PopulationRepository to interact with the database.
     *
     * @param repository                      The PopulationRepository instance for database operations.
     * @param populationRequirementRepository The PopulationRequirementRepository instance for database operations.
     */
    @Autowired
    public PopulationService(PopulationRepository repository,
                             PopulationRequirementRepository populationRequirementRepository) {
        super(repository);
        this.populationRequirementRepository = populationRequirementRepository;
    }

    /**
     * This method is used to create a new Population entity based on the provided PopulationInput DTO.
     * It first calls the super class's post method to create the Population entity.
     * It then calls the getRequirements method to retrieve the requirements for the population based on the input.
     * The requirements are set on the Population entity and saved to the repository.
     *
     * @param populationInput The DTO that contains the new values for the Population entity.
     * @return The newly created Population entity.
     */
    @Override
    @Transactional
    public Population post(PopulationInput populationInput) {
        var population = super.post(populationInput);
        population.setRequiredGoods(getRequirements(populationInput, population));
        return repository.save(population);
    }

    @Transactional
    @Override
    public Population put(UUID id, PopulationInput input) throws EntityNotFoundException {
        removeRequirements(id);
        var population = super.put(id, input);
        population.setRequiredGoods(getRequirements(input, population));
        return repository.save(population);
    }


    /**
     * This method is used to map a PopulationInput DTO to a Population entity.
     * It uses the builder pattern to create a new Population entity and sets its name property based on the DTO.
     *
     * @param populationInput The DTO that contains the new values for the Population entity.
     * @return The newly created Population entity.
     */
    @Override
    @Transactional
    public Population mapToEntity(PopulationInput populationInput) {
        return Population.builder()
                .name(populationInput.getName())
                .slug(SlugUtil.createSlug(populationInput.getName()))
                .requiredGoods(ServiceUtil.ifErrorThenNull(requirement ->
                        ServiceUtil.getHelper(requirement, populationRequirementRepository), populationInput.getRequirements()))
                .build();
    }

    /**
     * This method is used to update the properties of a Population entity based on the provided DTO.
     * It updates the name property of the entity to update.
     * The name is updated using the PatchUtil.patchHelper method, which checks if the new value is null.
     * If the new value is not null, it replaces the old value. If it is null, the old value is kept.
     * The method is marked as @Transactional, meaning it is part of a database transaction.
     *
     * @param entityToUpdate  The original Population entity that might be updated.
     * @param populationInput The DTO that contains the new values for the Population entity.
     * @return The updated Population entity.
     */
    @Override
    @Transactional
    public Population patch(Population entityToUpdate, PopulationInput populationInput) {
        entityToUpdate.setRequiredGoods(getRequirements(populationInput, entityToUpdate));
        entityToUpdate.setName(ServiceUtil.patchHelper(entityToUpdate.getName(), populationInput.getName()));
        return entityToUpdate;
    }

    /**
     * This method is used to remove the requirements associated with a given population entity.
     * It first checks if the population entity has any requirements associated with it.
     * If it does, it iterates over each requirement, sets the population of the requirement to null,
     * and saves the requirement back to the repository.
     *
     * @param entityToUpdate The Population entity from which the requirements are to be removed.
     */
    private void removeRequirements(Population entityToUpdate) {
        if (entityToUpdate.getRequiredGoods() != null) {
            entityToUpdate.getRequiredGoods().forEach(requirement -> {
                requirement.setPopulation(null);
                populationRequirementRepository.deleteById(requirement.getId());
                entityToUpdate.setRequiredGoods(null);
                repository.save(entityToUpdate);
            });
        }
    }

    /**
     * This method is used to remove the requirements associated with a given population entity.
     * It first retrieves the population entity by its id from the repository.
     * If the population entity is not found, it throws an EntityNotFoundException.
     * It then calls the removeRequirements method, passing the retrieved population entity as a parameter.
     *
     * @param id The id of the Population entity from which the requirements are to be removed.
     */
    private void removeRequirements(UUID id) {
        var population = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Population", id));
        removeRequirements(population);
    }

    /**
     * This method is used to get the requirements associated with a given population entity.
     * It first checks if the input requirements are null. If they are, it returns null.
     * It then creates a set of requirement ids from the input requirements.
     * It iterates over each requirement id, retrieves the requirement from the repository, and checks if the requirement is already associated with another population.
     * If it is, it throws an OccupiedRelationException.
     * It then iterates over the required goods of the population, checks if the requirement id is not in the set of requirement ids, and removes the requirement from the population.
     * Finally, it returns a set of requirements that are associated with the population.
     *
     * @param input The PopulationInput DTO that contains the new values for the Population entity.
     * @param population The Population entity for which the requirements are to be retrieved.
     * @return A set of PopulationRequirement entities that are associated with the population.
     */
    private Set<PopulationRequirement> getRequirements(PopulationInput input, Population population) {
        if (input.getRequirements() == null) {
            return null;
        }
        var requirementsIds = Arrays.stream(input.getRequirements())
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .map(UuidUtil::getFromString).collect(Collectors.toSet());

        requirementsIds.forEach(id -> {
            var requirement = populationRequirementRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PopulationRequirement", id));
            if (requirement.getPopulation() != null && !requirement.getPopulation().getId().equals(population.getId())) {
                throw new OccupiedRelationException("This requirement is already associated with another population. "
                        + id.toString() + " -> " + requirement.getPopulation().getName());
            }
        });

        population.getRequiredGoods().forEach(requirement -> {
            if (!requirementsIds.contains(requirement.getId())) {
                var todelete = populationRequirementRepository.getReferenceById(requirement.getId());
                System.out.println(todelete.getId());
                todelete.setPopulation(null);
                populationRequirementRepository.deleteById(todelete.getId());
                population.getRequiredGoods().remove(todelete);
                repository.save(population);
            }
        });


        return requirementsIds.stream()
                .map(id -> {
                    var re = populationRequirementRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PopulationRequirement", id));
                    re.setPopulation(population);
                    return populationRequirementRepository.saveAndFlush(re);
                })
                .collect(Collectors.toSet());
    }
}