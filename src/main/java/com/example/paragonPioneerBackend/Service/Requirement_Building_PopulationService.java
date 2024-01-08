package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "costBuildingPopulationService")
public class Requirement_Building_PopulationService extends BaseService<Requirement_Population_Building, Requirement_Population_BuildingRepository, Requirement_Population_BuildingDTO> {
    private final PopulationRepository populationRepository;
    private final BuildingRepository buildingRepository;

    @Autowired
    public Requirement_Building_PopulationService(Requirement_Population_BuildingRepository repository, PopulationRepository populationRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.populationRepository = populationRepository;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Requirement_Population_Building post(Requirement_Population_BuildingDTO costBuildingPopulationDTO) {
        return repository.save(
                Requirement_Population_Building.builder()
                        .population(populationRepository.findById(costBuildingPopulationDTO.getPopulationId()).get())
                        .building(buildingRepository.findById(costBuildingPopulationDTO.getBuildingId()).get())
                        .amount(costBuildingPopulationDTO.getAmount())
                        .build()
        );
    }

    @Override
    public Requirement_Population_Building putPatch(Requirement_Population_Building original, Requirement_Population_BuildingDTO costBuildingPopulationDTO) {
        original.setBuilding(costBuildingPopulationDTO.getBuildingId() == null ? original.getBuilding() : buildingRepository.findById(costBuildingPopulationDTO.getBuildingId()).get());
        original.setPopulation(costBuildingPopulationDTO.getPopulationId() == null ? original.getPopulation() : populationRepository.findById(costBuildingPopulationDTO.getPopulationId()).get());
        if (original.getAmount() != costBuildingPopulationDTO.getAmount()) {
            original.setAmount(costBuildingPopulationDTO.getAmount());
        }
        return original;
    }
}
