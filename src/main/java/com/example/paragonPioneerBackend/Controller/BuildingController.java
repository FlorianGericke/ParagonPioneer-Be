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

/**
 * BuildingController is a REST controller that handles HTTP requests related to buildings.
 * It extends the SlugableController and provides endpoints for fetching production and population buildings.
 * <p>
 * The BuildingController class is parameterized with the following types:
 * - Building: The entity type that this controller handles.
 * - BuildingRepository: The repository type used for accessing the database.
 * - BuildingInput: The DTO type used for creating and updating buildings.
 * - BuildingMapper: The mapper type used for converting between entities and DTOs.
 * - BuildingService<BuildingInput>: The service type used for business logic operations.
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


    @Override
    @Hidden
    public Building postEntity(BuildingInput buildingInput) {
        return super.postEntity(buildingInput);
    }

    @PostMapping(value = "/productionBuilding", produces = "application/json")
    public Building postProductionBuilding(@RequestBody ProductionBuildingInput buildingInput) {
        return super.postEntity(buildingInput);
    }

    @PostMapping(value = "/populationBuilding", produces = "application/json")
    public Building postPopulationBuilding(@RequestBody PopulationBuildingInput buildingInput) {
        return super.postEntity(buildingInput);
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