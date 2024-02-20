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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Handling all endpoints responding to building, extends BaseController.
 */
@Controller
@RequestMapping(path = "/api/v1/building")
public class BuildingController extends BaseController<Building, BuildingRepository, BuildingDTO, BuildingService<BuildingDTO>> {

    /**
     * Constructor for BuildingController, gets autowired
     *
     * @param service service the controller is using
     */
    @Autowired
    public BuildingController(BuildingService service) {
        super(service);
    }

    /**
     * get endpoint for find by name
     *
     * @param name to look for
     * @return list of all Buildings containing the name
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Building> getEntities(@RequestParam String name) {
        return service.findAllByNameContains(name);
    }

    /**
     * get endpoint
     *
     * @return List of all PopulationBuildings
     */
    @GetMapping(path = "/population", produces = "application/json")
    public @ResponseBody List<PopulationBuilding> getAllPopulationBuildings() {
        return service.getAlPopulationBuilding();
    }

    /**
     * get endpoint
     *
     * @return List of all ProductionBuildings
     */
    @GetMapping(path = "/production", produces = "application/json")
    public @ResponseBody List<ProductionBuilding> getAllProductionBuilding() {
        return service.getAllProductionBuilding();
    }

    /**
     * post endpoint
     *
     * @param dto dto of the population building to add
     * @return added PopulationBuilding
     */
    @PostMapping(path = "/population", produces = "application/json")
    public @ResponseBody Building postPopulationBuildingEntity(@RequestBody PopulationBuildingDTO dto) {
        System.out.println("found me 1");
        return service.post(dto);
    }

    /**
     * post endpoint
     *
     * @param dto dto of the production building to add
     * @return added ProductionBuilding
     */
    @PostMapping(path = "/production", produces = "application/json")
    public @ResponseBody Building postProductionBuildingEntity(@RequestBody ProductionBuildingDTO dto) {
        System.out.println("found me 2");
        return service.post(dto);
    }

    /**
     * put endpoint
     *
     * @param id  of the PopulationBuilding to update
     * @param dto containing the update information
     * @return updated ProductionBuilding
     */
    @PutMapping(path = "/population/{id}", produces = "application/json")
    public @ResponseBody Building putPopulationBuildingEntity(@PathVariable UUID id, @RequestBody PopulationBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    /**
     * patch endpoint
     *
     * @param id  of the PopulationBuilding to update
     * @param dto containing the update information
     * @return updated ProductionBuilding
     */
    @PatchMapping(path = "/population/{id}", produces = "application/json")
    public @ResponseBody Building patchPopulationBuildingEntity(@PathVariable UUID id, @RequestBody PopulationBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    /**
     * put endpoint
     *
     * @param id  of the ProductionBuilding to update
     * @param dto containing the update information
     * @return updated ProductionBuilding
     */
    @PutMapping(path = "/production/{id}", produces = "application/json")
    public @ResponseBody Building putProductionBuildingEntity(@PathVariable UUID id, @RequestBody ProductionBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    /**
     * patch endpoint
     *
     * @param id  of the ProductionBuilding to update
     * @param dto containing the update information
     * @return updated ProductionBuilding
     */
    @PatchMapping(path = "/production/{id}", produces = "application/json")
    public @ResponseBody Building patchProductionBuildingEntity(@PathVariable UUID id, @RequestBody ProductionBuildingDTO dto) {
        return service.putPatch(id, dto);
    }
}
