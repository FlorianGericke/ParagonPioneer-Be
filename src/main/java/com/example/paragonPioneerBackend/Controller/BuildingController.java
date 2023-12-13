package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/building")
public class BuildingController extends BaseController<Building,BuildingRepository,BuildingDTO,BuildingService> {

    @Autowired
    public BuildingController(BuildingService service) {
        super(service);
    }
}
