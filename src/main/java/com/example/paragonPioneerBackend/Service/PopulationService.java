package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * the Base handling the CRUD functions for the Populations Entities. Extends BaseService
 */
@Component(value = "populationService")
public class PopulationService extends BaseService<Population, PopulationRepository, PopulationDTO> {

    /**
     * Constructs a new PopulationService. is Autowired
     *
     * @param repository the repository the Service should use
     */
    @Autowired
    public PopulationService(PopulationRepository repository) {
        super(repository);
    }

    /**
     * Adds new Entity to the database
     * Overridden from BaseService
     *
     * @param populationDTO DTO responding to the Entity to add.
     * @return the added entity
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
     * Find all Population with name contains
     *
     * @param name the string contained
     * @return list of Population matching
     */
    public List<Population> findAllByNameContains(String name) {
        return repository.findAllByNameContains(name);
    }



    /**
     * Find Good by slug
     *
     * @param slug the string contained
     * @return list of Goods matching
     */
    public Optional<Population> findBySlug(String slug) {
        return repository.findBySlugIs(slug);
    }

    /**
     * Find Population by Name
     *
     * @param name the string contained
     * @return list of Goods matching
     */
    public Optional<Population> findByName(String name) {
        return repository.findByNameIs(name);
    }

    /**
     * Updates an Entity
     * Overridden from BaseService
     *
     * @param original      original entity
     * @param populationDTO dto containing the updated data
     * @return the update entity
     */
    @Override
    public Population putPatch(Population original, PopulationDTO populationDTO) {
        original.setName(populationDTO.getName() != null ? populationDTO.getName() : original.getName());
        original.setSlug(populationDTO.getSlug() != null ? populationDTO.getSlug() : original.getSlug());
        return original;
    }
}
