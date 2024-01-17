package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.GoodDTO;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Handling all endpoints responding to goods, extends BaseController.
 */
@Controller
@RequestMapping(path = "/api/v1/good")
public class GoodController extends BaseController<Good, GoodRepository, GoodDTO, GoodService> {

    /**
     * Constructor for GoodController, gets autowired
     *
     * @param service service the controller is using
     */
    @Autowired
    public GoodController(GoodService service) {
        super(service);
    }

    /**
     * get endpoint for find by name
     *
     * @param name to look for
     * @return list of all Goods containing the name
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Good> getEntities(@RequestParam String name) {
        return service.find(name);
    }
}
