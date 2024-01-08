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

@Controller
@RequestMapping(path = "/api/v1/building")
public class BuildingController extends BaseController<Building,BuildingRepository,BuildingDTO,BuildingService<BuildingDTO>> {

    @Autowired
    public BuildingController(BuildingService service) {
        super(service);
    }

    @GetMapping(path = "/population", produces = "application/json")
    public @ResponseBody List<PopulationBuilding> getAllPopulationBuildings() {
        return service.getAlPopulationBuilding();
    }

    @GetMapping(path = "/production", produces = "application/json")
    public @ResponseBody List<ProductionBuilding> getAllProductionBuilding() {
        return service.getAllProductionBuilding();
    }

    @PostMapping(path = "/population", produces = "application/json")
    public @ResponseBody Building postPopulationBuildingEntity(@RequestBody PopulationBuildingDTO dto) {
        System.out.println("found me 1");
        return service.post(dto);
    }

    @PostMapping(path = "/production", produces = "application/json")
    public @ResponseBody Building postProductionBuildingEntity(@RequestBody ProductionBuildingDTO dto) {
        System.out.println("found me 2");
        return service.post(dto);
    }

    @PutMapping(path = "/population/{id}", produces = "application/json")
    public @ResponseBody Building putPopulationBuildingEntity(@PathVariable UUID id, @RequestBody PopulationBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    @PatchMapping(path = "/population/{id}", produces = "application/json")
    public @ResponseBody Building patchPopulationBuildingEntity(@PathVariable UUID id, @RequestBody PopulationBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    @PutMapping(path = "/production/{id}", produces = "application/json")
    public @ResponseBody Building putProductionBuildingEntity(@PathVariable UUID id, @RequestBody ProductionBuildingDTO dto) {
        return service.putPatch(id, dto);
    }

    @PatchMapping(path = "/production/{id}", produces = "application/json")
    public @ResponseBody Building patchProductionBuildingEntity(@PathVariable UUID id, @RequestBody ProductionBuildingDTO dto) {
        return service.putPatch(id, dto);
    }
}
