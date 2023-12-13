package com.example.ppapi.Controller;

import com.example.ppapi.Dto.Population_RequirementDTO;
import com.example.ppapi.Entity.JoinTables.Population_Requirement;
import com.example.ppapi.Repository.Population_RequirementRepository;
import com.example.ppapi.Service.Population_RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/requirement")
public class Population_RequirementController extends BaseController<Population_Requirement, Population_RequirementRepository, Population_RequirementDTO, Population_RequirementService> {

    @Autowired
    public Population_RequirementController(Population_RequirementService service) {
        super(service);
    }
}
