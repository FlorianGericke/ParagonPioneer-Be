package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.GoodDTO;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handling all endpoints responding to goods, extends BaseController.
 *
 */
@RestController
@RequestMapping(path = "/api/v1/good")
public class GoodController extends BaseController<Good, GoodRepository, GoodDTO, GoodService> {

    /**
     * Constructor for GoodController, gets autowired
     * @param service service the controller is using
     */
    @Autowired
    public GoodController(GoodService service) {
        super(service);
    }
}
