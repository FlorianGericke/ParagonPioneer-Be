package com.example.ppapi.Service;

import com.example.ppapi.Dto.Population_RequirementDTO;
import com.example.ppapi.Entity.JoinTables.Population_Requirement;
import com.example.ppapi.Repository.GoodRepository;
import com.example.ppapi.Repository.PopulationRepository;
import com.example.ppapi.Repository.Population_RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "population_RequirementService")
public class Population_RequirementService extends BaseService<Population_Requirement, Population_RequirementRepository, Population_RequirementDTO> {

    private final GoodRepository goodRepository;
    private final PopulationRepository populationRepository;

    @Autowired
    public Population_RequirementService(Population_RequirementRepository repository, GoodRepository goodRepository, PopulationRepository populationRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.populationRepository = populationRepository;
    }

    @Override
    public Population_Requirement post(Population_RequirementDTO populationRequirementDTO) {
        return repository.save(Population_Requirement.builder()
                .population(populationRepository.findById(populationRequirementDTO.getPopulationId()).get())
                .good(goodRepository.findById(populationRequirementDTO.getGoodId()).get())
                .income(populationRequirementDTO.getIncome())
                .consumption(populationRequirementDTO.getConsumption())
                .isBasic(populationRequirementDTO.isBasic())
                .build());
    }

    @Override
    public Population_Requirement putPatch(Population_Requirement original, Population_RequirementDTO populationRequirementDTO) {
        original.setPopulation(populationRequirementDTO.getPopulationId() == null ? original.getPopulation() : populationRepository.findById(populationRequirementDTO.getPopulationId()).get());
        original.setGood(populationRequirementDTO.getGoodId() == null ? original.getGood() : goodRepository.findById(populationRequirementDTO.getGoodId()).get());
        if (original.getIncome() != populationRequirementDTO.getIncome()) {
            original.setIncome(populationRequirementDTO.getIncome());
        }
        if (original.isBasic() != populationRequirementDTO.isBasic()) {
            original.setBasic(populationRequirementDTO.isBasic());
        }
        return original;
    }
}
