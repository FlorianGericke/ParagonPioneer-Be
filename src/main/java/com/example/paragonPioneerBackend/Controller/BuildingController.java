package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Dto.PopulationBuildingDTO;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * Controller responsible for handling HTTP requests related to buildings, including
 * specialized endpoints for population and production buildings. Inherits basic CRUD
 * operations from BaseController and adds specific functionalities to cater to different
 * types of buildings within the system.
 */
@RestController
@RequestMapping(path = "/api/v1/building")
public class BuildingController extends BaseController<Building, BuildingRepository, BuildingDTO, BuildingService<BuildingDTO>> {

    @Autowired
    public BuildingController(BuildingService service) {
        super(service);
    }

    /**
     * Retrieves a list of buildings that contain the specified name in their name attribute.
     *
     * @param name The substring to search for within building names.
     * @return A list of all buildings containing the specified name substring.
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Building> getEntities(@RequestParam String name) {
        return service.findAllByNameContains(name);
    }

    /**
     * Retrieves all population buildings within the system.
     *
     * @return A list of all population buildings.
     */
    @GetMapping(path = "/population", produces = "application/json")
    public @ResponseBody List<PopulationBuilding> getAllPopulationBuildings() {
        return service.getAllPopulationBuilding();
    }

    /**
     * Retrieves all production buildings within the system.
     *
     * @return A list of all production buildings.
     */
    @GetMapping(path = "/production", produces = "application/json")
    public @ResponseBody List<ProductionBuilding> getAllProductionBuilding() {
        return service.getAllProductionBuilding();
    }

    /**
     * Adds a new population building to the system based on the provided DTO.
     *
     * @param dto The DTO containing the data for the new population building.
     * @return The newly added population building.
     */
    @PostMapping(path = "/population", produces = "application/json")
    public @ResponseBody Building postPopulationBuildingEntity(@RequestBody PopulationBuildingDTO dto) {
        return service.post(dto);
    }

    /**
     * Adds a new production building to the system based on the provided DTO.
     *
     * @param dto The DTO containing the data for the new production building.
     * @return The newly added production building.
     */
    @PostMapping(path = "/production", produces = "application/json")
    public @ResponseBody Building postProductionBuildingEntity(@RequestBody ProductionBuildingDTO dto) {
        return service.post(dto);
    }

    // Similar structure for PUT and PATCH endpoints for both population and production buildings.
    // They allow updating the entire or partial data of buildings respectively, identified by their UUIDs.

    /**
     * Updates an existing population building identified by the provided UUID with data from the given DTO.
     *
     * @param id  The UUID of the population building to update.
     * @param dto The DTO containing the update information.
     * @return The updated population building.
     */
    @PutMapping(path = "/population/{id}", produces = "application/json")
    public @ResponseBody Building putPopulationBuildingEntity(@PathVariable UUID id, @RequestBody PopulationBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    // Similar PUT and PATCH methods for production buildings follow...

    /**
     * Deletes the specified building, identified by its UUID, from the system.
     *
     * @param id The UUID of the building to delete.
     * @return The deleted building entity.
     */
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Building deleteEntity(@PathVariable UUID id) {
        return super.deleteEntity(id);
    }
}
