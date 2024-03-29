package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.PopulationInput;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Service.generic.SlugableService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for managing populations within the application. It provides functionality to add, retrieve,
 * update, and find populations based on various criteria. This service extends the generic BaseService,
 * specifying Population as the entity type, PopulationRepository as the repository, and PopulationDTO
 * as the data transfer object (DTO).
 */
@org.springframework.stereotype.Service()
public class PopulationService extends SlugableService<Population, PopulationRepository, PopulationInput> {

    /**
     * Autowired constructor to inject PopulationRepository dependency. This setup facilitates
     * interaction with the database regarding Population entities.
     *
     * @param repository The PopulationRepository instance for database operations.
     */
    @Autowired
    public PopulationService(PopulationRepository repository) {
        super(repository);
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
                .build();
    }

    /**
     * This method is used to update the properties of a Population entity based on the provided DTO.
     * It updates the name property of the entity to update.
     * The name is updated using the PatchUtil.patchHelper method, which checks if the new value is null.
     * If the new value is not null, it replaces the old value. If it is null, the old value is kept.
     * The method is marked as @Transactional, meaning it is part of a database transaction.
     *
     * @param entityToUpdate The original Population entity that might be updated.
     * @param populationInput The DTO that contains the new values for the Population entity.
     * @return The updated Population entity.
     */
    @Override
    @Transactional
    public Population patch(Population entityToUpdate, PopulationInput populationInput) {
        entityToUpdate.setName(ServiceUtil.patchHelper(entityToUpdate.getName(), populationInput.getName()));
        return entityToUpdate;
    }
}
