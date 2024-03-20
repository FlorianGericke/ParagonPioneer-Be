package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service for managing populations within the application. It provides functionality to add, retrieve,
 * update, and find populations based on various criteria. This service extends the generic BaseService,
 * specifying Population as the entity type, PopulationRepository as the repository, and PopulationDTO
 * as the data transfer object (DTO).
 */
@Service(value = "populationService")
public class PopulationService extends BaseService<Population, PopulationRepository, PopulationDTO> {

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
     * Creates a new Population entity based on the provided DTO and saves it to the database. This method
     * overrides the abstract post method from BaseService.
     *
     * @param populationDTO The DTO containing data for the new population entity.
     * @return The newly created and saved Population entity.
     */
    @Override
    public Population post(PopulationDTO populationDTO) {
        return repository.save(
                Population.builder()
                        .name(populationDTO.getName())
                        .slug(populationDTO.getSlug().isEmpty() ? SlugUtil.createSlug(populationDTO.getName()) : populationDTO.getSlug())
                        .build()
        );
    }

    /**
     * Retrieves a list of all Population entities that contain the given name string. This method
     * utilizes the repository to perform a search based on name containment.
     *
     * @param name The string to be contained within the population name.
     * @return A list of Population entities matching the search criteria.
     */
    public List<Population> findAllByNameContains(String name) {
        return repository.findAllByNameContains(name);
    }

    /**
     * Finds a Population entity by its slug. This method provides a way to retrieve populations based on
     * a unique slug value.
     *
     * @param slug The slug associated with a specific population.
     * @return An Optional containing the found Population entity, if any.
     */
    public Population findBySlug(String slug) throws EntityNotFoundException {
        return repository.findBySlugIs(slug).orElseThrow(() -> new EntityNotFoundException("Slug", slug));
    }

    /**
     * Finds a Population entity by its name. This method offers an alternative way to retrieve populations
     * by their exact name.
     *
     * @param name The exact name of the population to find.
     * @return An Optional containing the found Population entity, if any.
     */
    public Population findByName(String name) throws EntityNotFoundException {
        return repository.findByNameIs(name).orElseThrow(() -> new EntityNotFoundException("Name", name));
    }

    /**
     * Updates an existing Population entity with data from the provided DTO. This method overrides the
     * abstract putPatch method from BaseService to apply the updates to the Population entity.
     *
     * @param original      The original Population entity to be updated.
     * @param populationDTO The DTO containing the updated data for the population.
     * @return The updated Population entity.
     */
    @Override
    public Population putPatch(Population original, PopulationDTO populationDTO) throws EntityNotFoundException {
        original.setName(populationDTO.getName() != null ? populationDTO.getName() : original.getName());
        original.setSlug(populationDTO.getSlug() != null ? populationDTO.getSlug() : original.getSlug());
        return original;
    }
}
