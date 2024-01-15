package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * the Base handling the CRUD functions for the Populations Entities. Extends BaseService
 */
@Service(value = "populationService")
public class PopulationService extends BaseService<Population, PopulationRepository, PopulationDTO> {

    /**
     *  Constructs a new PopulationService. is Autowired
     * @param repository the repository the Service should use
     */
    @Autowired
    public PopulationService(PopulationRepository repository) {
        super(repository);
    }

    /**
     *  Adds new Entity to the database
     * Overridden from BaseService
     * @param populationDTO DTO responding to the Entity to add.
     * @return the added entity
     */
    @Override
    public Population post(PopulationDTO populationDTO) {
        return repository.save(
                Population.builder()
                        .name(populationDTO.getName())
                        .build()
        );
    }

    /**
     * Updates an Entity
     * Overridden from BaseService
     * @param original original entity
     * @param populationDTO dto containing the updated data
     * @return the update entity
     */
    @Override
    public Population putPatch(Population original, PopulationDTO populationDTO) {
        original.setName(populationDTO.getName() != null ? populationDTO.getName() : original.getName());
        return original;
    }
}
