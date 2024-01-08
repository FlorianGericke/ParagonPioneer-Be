package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
