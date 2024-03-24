package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.*;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service class for managing relationships between buildings and their required populations.
 * It facilitates CRUD operations on Requirement_Population_Building entities, leveraging
 * Requirement_Population_BuildingRepository for database interactions. Additionally, it
 * utilizes PopulationRepository and BuildingRepository for operations related to Population
 * and Building entities that are part of these relationships.
 */
@Service(value = "costBuildingPopulationService")
public class Requirement_Building_PopulationService extends BaseService<Requirement_Population_Building, Requirement_Population_BuildingRepository, Requirement_Population_BuildingDTO> {

    private final PopulationRepository populationRepository;
    private final BuildingRepository buildingRepository;

    /**
     * Autowires the necessary repositories for managing relationships between buildings
     * and population requirements, providing database access for CRUD operations.
     *
     * @param repository           The Requirement_Population_BuildingRepository for database operations on requirement relations.
     * @param populationRepository The PopulationRepository for accessing Population entities.
     * @param buildingRepository   The BuildingRepository for accessing Building entities.
     */
    @Autowired
    public Requirement_Building_PopulationService(Requirement_Population_BuildingRepository repository, PopulationRepository populationRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.populationRepository = populationRepository;
        this.buildingRepository = buildingRepository;
    }

    /**
     * Creates and saves a new Requirement_Population_Building entity based on the provided DTO,
     * establishing a relationship between a building and the population required for that building.
     * Overrides the abstract post method from BaseService tailored to Requirement_Population_Building entities.
     *
     * @param costBuildingPopulationDTO The DTO containing data for creating a new requirement relationship.
     * @return The newly created Requirement_Population_Building entity.
     */
    @Override
    public Requirement_Population_Building post(Requirement_Population_BuildingDTO costBuildingPopulationDTO) {
        return repository.save(
                Requirement_Population_Building.builder()
                        .population(UuidUtil.parseUuidFromStringOrNull(costBuildingPopulationDTO.getPopulationId()) == null ?
                                null :
                                populationRepository.findById(UuidUtil.parseUuidFromStringOrNull(costBuildingPopulationDTO.getPopulationId())).orElse(null))
                        .building(UuidUtil.parseUuidFromStringOrNull(costBuildingPopulationDTO.getBuildingId()) == null ?
                                null :
                                buildingRepository.findById(UuidUtil.parseUuidFromStringOrNull(costBuildingPopulationDTO.getBuildingId())).orElse(null))
                        .amount(costBuildingPopulationDTO.getAmount())
                        .build()
        );
    }

    /**
     * Updates an existing Requirement_Population_Building entity with the data provided in the DTO.
     * This method allows modifying the building, population, and the amount required.
     * Overrides the abstract putPatch method from BaseService tailored to Requirement_Population_Building entities.
     *
     * @param original                  The original Requirement_Population_Building entity to be updated.
     * @param costBuildingPopulationDTO The DTO containing the updated relationship data.
     * @return The updated Requirement_Population_Building entity.
     */
    @Override
    public Requirement_Population_Building putPatch(Requirement_Population_Building original, Requirement_Population_BuildingDTO costBuildingPopulationDTO) throws EntityNotFoundException {
        original.setBuilding(costBuildingPopulationDTO.getBuildingId() == null ? original.getBuilding() : buildingRepository.findById(UUID.fromString(costBuildingPopulationDTO.getBuildingId())).get());
        original.setPopulation(costBuildingPopulationDTO.getPopulationId() == null ? original.getPopulation() : populationRepository.findById(UUID.fromString(costBuildingPopulationDTO.getPopulationId())).get());
        if (original.getAmount() != costBuildingPopulationDTO.getAmount()) {
            original.setAmount(costBuildingPopulationDTO.getAmount());
        }
        return original;
    }
}