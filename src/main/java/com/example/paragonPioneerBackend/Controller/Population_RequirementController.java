package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.Population_RequirementDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Population_Requirement;
import com.example.paragonPioneerBackend.Repository.Population_RequirementRepository;
import com.example.paragonPioneerBackend.Service.EntityServices.Population_RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handling all endpoints responding to population requirement relation, extends BaseController.
 *
 */
@Controller
@RequestMapping(path = "/api/v1/requirement")
public class Population_RequirementController extends BaseController<Population_Requirement, Population_RequirementRepository, Population_RequirementDTO, Population_RequirementService> {

    /**
     * Constructor for Population_RequirementController, gets autowired
     * @param service service the controller is using
     */
    @Autowired
    public Population_RequirementController(Population_RequirementService service) {
        super(service);
    }
}
