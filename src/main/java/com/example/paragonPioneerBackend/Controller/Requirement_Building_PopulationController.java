package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.Requirement_Population_BuildingDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Repository.Requirement_Population_BuildingRepository;
import com.example.paragonPioneerBackend.Service.Requirement_Building_PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/requirement/building_population")
public class Requirement_Building_PopulationController extends BaseController<Requirement_Population_Building, Requirement_Population_BuildingRepository, Requirement_Population_BuildingDTO, Requirement_Building_PopulationService> {

    @Autowired
    public Requirement_Building_PopulationController(Requirement_Building_PopulationService service) {
        super(service);
    }
}
