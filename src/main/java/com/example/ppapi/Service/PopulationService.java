package com.example.ppapi.Service;

import com.example.ppapi.Dto.PopulationDTO;
import com.example.ppapi.Entity.Population;
import com.example.ppapi.Repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "populationService")
public class PopulationService extends BaseService<Population, PopulationRepository, PopulationDTO> {

    @Autowired
    public PopulationService(PopulationRepository repository) {
        super(repository);
    }

    @Override
    public Population post(PopulationDTO populationDTO) {
        return repository.save(
                Population.builder()
                        .name(populationDTO.getName())
                        .build()
        );
    }

    @Override
    public Population putPatch(Population original, PopulationDTO populationDTO) {
        original.setName(populationDTO.getName() != null ? populationDTO.getName() : original.getName());
        return original;
    }
}
