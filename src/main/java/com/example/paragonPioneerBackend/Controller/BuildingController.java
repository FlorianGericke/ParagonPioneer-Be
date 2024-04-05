package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.SlugableController;
import com.example.paragonPioneerBackend.Dto.requests.BuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.PopulationBuildingInput;
import com.example.paragonPioneerBackend.Dto.requests.ProductionBuildingInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.BuildingMapper;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Service.BuildingService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * BuildingController is a REST controller that handles HTTP requests related to buildings.
 * It extends the SlugableController and provides endpoints for fetching production and population buildings.
 * <p>
 * The BuildingController class is parameterized with the following types:
 * - Building: The entity type that this controller handles.
 * - BuildingRepository: The repository type used for accessing the database.
 * - BuildingInput: The DTO type used for creating and updating buildings.
 * - BuildingMapper: The mapper type used for converting between entities and DTOs.
 */
@RestController
@RequestMapping(path = "/api/v1/building")
@Tag(name = "Building", description = "Endpoints for managing buildings")
public class BuildingController extends SlugableController<Building, BuildingRepository, BuildingInput, BuildingMapper, BuildingService<BuildingInput>> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public BuildingController(BuildingService<BuildingInput> service, BuildingMapper mapper) {
        super(service, mapper);
    }

    /**
     * Endpoint to create a new building.
     * It uses the service to create the building and the mapper to map the entity to response DTO.
     * This method is hidden from the Swagger UI.
     *
     * @param buildingInput The DTO containing the data for the new building.
     * @return The created building as a DTO.
     */
    @Override
    @Hidden
    public BuildingMapper postEntity(BuildingInput buildingInput) {
        return super.postEntity(buildingInput);
    }

    /**
     * Endpoint to update an existing building.
     * It uses the service to update the building and the mapper to map the entity to response DTO.
     * This method is hidden from the Swagger UI.
     *
     * @param id The ID of the building to update.
     * @param buildingInput The DTO containing the updated data for the building.
     * @return The updated building as a DTO.
     */
    @Override
    @Hidden
    public BuildingMapper putEntity(UUID id, BuildingInput buildingInput) {
        return super.putEntity(id, buildingInput);
    }

    /**
     * Endpoint to partially update an existing building.
     * It uses the service to update the building and the mapper to map the entity to response DTO.
     * This method is hidden from the Swagger UI.
     *
     * @param id The ID of the building to update.
     * @param buildingInput The DTO containing the updated data for the building.
     * @return The updated building as a DTO.
     */
    @Override
    @Hidden
    public BuildingMapper patchEntity(UUID id, BuildingInput buildingInput) {
        return super.patchEntity(id, buildingInput);
    }

    /**
     * Endpoint to create a new production building.
     * It uses the service to create the building and the mapper to map the entity to response DTO.
     *
     * @param buildingInput The DTO containing the data for the new production building.
     * @return The created production building as a DTO.
     */
    @PostMapping(value = "/productionBuilding", produces = "application/json")
    public BuildingMapper postProductionBuilding(@RequestBody ProductionBuildingInput buildingInput) {
        return super.postEntity(buildingInput);
    }

    /**
     * Endpoint to create a new population building.
     * It uses the service to create the building and the mapper to map the entity to response DTO.
     *
     * @param buildingInput The DTO containing the data for the new population building.
     * @return The created population building as a DTO.
     */
    @PostMapping(value = "/populationBuilding", produces = "application/json")
    public BuildingMapper postPopulationBuilding(@RequestBody PopulationBuildingInput buildingInput) {
        return super.postEntity(buildingInput);
    }

    /**
     * Endpoint to update an existing production building.
     * It uses the service to update the building and the mapper to map the entity to response DTO.
     *
     * @param id The ID of the production building to update.
     * @param buildingInput The DTO containing the updated data for the production building.
     * @return The updated production building as a DTO.
     */
    @PutMapping(value = "/productionBuilding/{id}", produces = "application/json")
    public BuildingMapper putProductionBuilding(@PathVariable UUID id, @RequestBody ProductionBuildingInput buildingInput) {
        return super.putEntity(id, buildingInput);
    }

    /**
     * Endpoint to update an existing population building.
     * It uses the service to update the building and the mapper to map the entity to response DTO.
     *
     * @param id The ID of the population building to update.
     * @param buildingInput The DTO containing the updated data for the population building.
     * @return The updated population building as a DTO.
     */
    @PutMapping(value = "/populationBuilding/{id}", produces = "application/json")
    public BuildingMapper putPopulationBuilding(@PathVariable UUID id, @RequestBody PopulationBuildingInput buildingInput) {
        return super.putEntity(id, buildingInput);
    }

    /**
     * Endpoint to partially update an existing production building.
     * It uses the service to update the building and the mapper to map the entity to response DTO.
     *
     * @param id The ID of the production building to update.
     * @param buildingInput The DTO containing the updated data for the production building.
     * @return The updated production building as a DTO.
     */
    @PatchMapping(value = "/productionBuilding/{id}", produces = "application/json")
    public BuildingMapper patchProductionBuilding(@PathVariable UUID id, @RequestBody ProductionBuildingInput buildingInput) {
        return super.patchEntity(id, buildingInput);
    }

    /**
     * Endpoint to partially update an existing population building.
     * It uses the service to update the building and the mapper to map the entity to response DTO.
     *
     * @param id The ID of the population building to update.
     * @param buildingInput The DTO containing the updated data for the population building.
     * @return The updated population building as a DTO.
     */
    @PatchMapping(value = "/populationBuilding/{id}", produces = "application/json")
    public BuildingMapper patchPopulationBuilding(@PathVariable UUID id, @RequestBody PopulationBuildingInput buildingInput) {
        return super.patchEntity(id, buildingInput);
    }

    /**
     * Endpoint to fetch all production buildings.
     * It uses the service to fetch the buildings and the mapper to map the entities to response DTOs.
     *
     * @param pageable The pagination information.
     * @return A page of BuildingMapper objects.
     */
    @GetMapping(value = "/productionBuilding", produces = "application/json")
    public @ResponseBody Page<BuildingMapper> getProductionBuildings(@ParameterObject Pageable pageable) {
        return service.getAllProductionBuilding(pageable).map(mapper::map);
    }

    /**
     * Endpoint to fetch all population buildings.
     * It uses the service to fetch the buildings and the mapper to map the entities to response DTOs.
     *
     * @param pageable The pagination information.
     * @return A page of BuildingMapper objects.
     */
    @GetMapping(value = "/populationBuilding", produces = "application/json")
    public @ResponseBody Page<BuildingMapper> getPopulationBuildings(@ParameterObject Pageable pageable) {
        return service.getAllPopulationBuilding(pageable).map(mapper::map);
    }
}