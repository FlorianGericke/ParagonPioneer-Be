package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
/**
 * Service handling the functionality of the required Population for a building. Extends BaseService
 */
@Component(value = "costBuildingPopulationService")
public class Requirement_Building_PopulationService extends BaseService<Requirement_Population_Building, Requirement_Population_BuildingRepository, Requirement_Population_BuildingDTO> {
    private final PopulationRepository populationRepository;
    private final BuildingRepository buildingRepository;

    /**
     * Constructs a new Requirement_Building_PopulationService. is Autowired
     * @param repository the repository the Service should use
     * @param populationRepository repository the Service should use
     * @param buildingRepository repository the Service should use
     */
    @Autowired
    public Requirement_Building_PopulationService(Requirement_Population_BuildingRepository repository, PopulationRepository populationRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.populationRepository = populationRepository;
        this.buildingRepository = buildingRepository;
    }

    /**
     * Adds new Entity to the database
     * Overridden from BaseService
     * @param costBuildingPopulationDTO DTO responding to the Entity to add.
     * @return the added entity
     */
    @Override
    public Requirement_Population_Building post(Requirement_Population_BuildingDTO costBuildingPopulationDTO) {
        return repository.save(
                Requirement_Population_Building.builder()
                        .population(populationRepository.findById(UUID.fromString(costBuildingPopulationDTO.getPopulationId())).get())
                        .building(buildingRepository.findById(UUID.fromString(costBuildingPopulationDTO.getBuildingId())).get())
                        .amount(costBuildingPopulationDTO.getAmount())
                        .build()
        );
    }

    /**
     * Updates an Entity
     * Overridden from BaseService
     * @param original original entity
     * @param costBuildingPopulationDTO dto containing the updated data
     * @return the update entity
     */
    @Override
    public Requirement_Population_Building putPatch(Requirement_Population_Building original, Requirement_Population_BuildingDTO costBuildingPopulationDTO) {
        original.setBuilding(costBuildingPopulationDTO.getBuildingId() == null ? original.getBuilding() : buildingRepository.findById(UUID.fromString(costBuildingPopulationDTO.getBuildingId())).get());
        original.setPopulation(costBuildingPopulationDTO.getPopulationId() == null ? original.getPopulation() : populationRepository.findById(UUID.fromString(costBuildingPopulationDTO.getPopulationId())).get());
        if (original.getAmount() != costBuildingPopulationDTO.getAmount()) {
            original.setAmount(costBuildingPopulationDTO.getAmount());
        }
        return original;
    }
}
