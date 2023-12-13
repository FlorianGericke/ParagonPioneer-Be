package com.example.ppapi.Controller;

import com.example.ppapi.Dto.PopulationDTO;
import com.example.ppapi.Entity.Population;
import com.example.ppapi.Repository.PopulationRepository;
import com.example.ppapi.Service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/population")
public class PopulationController extends BaseController<Population, PopulationRepository, PopulationDTO, PopulationService> {

    @Autowired
    public PopulationController(PopulationService service) {
        super(service);
    }
}
