package com.example.ppapi.Controller;

import com.example.ppapi.Dto.BuildingDTO;
import com.example.ppapi.Entity.Building;
import com.example.ppapi.Repository.BuildingRepository;
import com.example.ppapi.Service.BuildingService;
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
