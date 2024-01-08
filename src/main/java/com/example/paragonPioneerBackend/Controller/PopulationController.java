package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handling all endpoints responding to populations, extends BaseController.
 *
 */
@Controller
@RequestMapping(path = "/api/v1/population")
public class PopulationController extends BaseController<Population, PopulationRepository, PopulationDTO, PopulationService> {

    /**
     * Constructor for PopulationController, gets autowired
     * @param service service the controller is using
     */
    @Autowired
    public PopulationController(PopulationService service) {
        super(service);
    }
}
