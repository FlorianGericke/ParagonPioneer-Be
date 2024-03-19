package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.PopulationDTO;
import com.example.paragonPioneerBackend.Entity.Population;
import com.example.paragonPioneerBackend.Repository.PopulationRepository;
import com.example.paragonPioneerBackend.Service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Handling all endpoints responding to populations, extends BaseController.
 */
@Controller
@RequestMapping(path = "/api/v1/population")
public class PopulationController extends BaseController<Population, PopulationRepository, PopulationDTO, PopulationService> {

    /**
     * Constructor for PopulationController, gets autowired
     *
     * @param service service the controller is using
     */
    @Autowired
    public PopulationController(PopulationService service) {
        super(service);
    }

    /**
     * get endpoint for find by name
     *
     * @param name to look for
     * @return list of all Populations containing the name
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Population> getEntities(@RequestParam String name) {
        return service.findAllByNameContains(name);
    }
}
