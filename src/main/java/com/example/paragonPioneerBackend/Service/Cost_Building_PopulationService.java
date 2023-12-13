package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Cost_Building_PopulationDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Population;
import com.example.paragonPioneerBackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = " costBuildingPopulationService")
public class Cost_Building_PopulationService extends BaseService<Cost_Building_Population, Cost_Building_PopulationRepository, Cost_Building_PopulationDTO> {
    private final PopulationRepository populationRepository;
    private final BuildingRepository buildingRepository;

    @Autowired
    public Cost_Building_PopulationService(Cost_Building_PopulationRepository repository, PopulationRepository populationRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.populationRepository = populationRepository;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Cost_Building_Population post(Cost_Building_PopulationDTO costBuildingPopulationDTO) {
        return repository.save(
                Cost_Building_Population.builder()
                        .population(populationRepository.findById(costBuildingPopulationDTO.getPopulationId()).get())
                        .building(buildingRepository.findById(costBuildingPopulationDTO.getBuildingId()).get())
                        .amount(costBuildingPopulationDTO.getAmount())
                        .build()
        );
    }

    @Override
    public Cost_Building_Population putPatch(Cost_Building_Population original, Cost_Building_PopulationDTO costBuildingPopulationDTO) {
        original.setBuilding(costBuildingPopulationDTO.getBuildingId() == null ? original.getBuilding() : buildingRepository.findById(costBuildingPopulationDTO.getBuildingId()).get());
        original.setPopulation(costBuildingPopulationDTO.getPopulationId() == null ? original.getPopulation() : populationRepository.findById(costBuildingPopulationDTO.getPopulationId()).get());
        if (original.getAmount() != costBuildingPopulationDTO.getAmount()) {
            original.setAmount(costBuildingPopulationDTO.getAmount());
        }
        return original;
    }
}
