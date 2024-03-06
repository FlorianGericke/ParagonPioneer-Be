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
 * Controller responsible for handling HTTP requests related to the Good entity.
 * It extends the generic BaseController to provide CRUD operations for Good entities
 * and adds a custom method for searching goods by name. This controller uses the GoodService
 * to interact with the database and perform operations on Good entities.
 */
@Controller
@RequestMapping(path = "/api/v1/good")
public class GoodController extends BaseController<Good, GoodRepository, GoodDTO, GoodService> {

    /**
     * Constructs a new GoodController with the specified GoodService.
     * The GoodService is injected by Spring's dependency injection mechanism and is used
     * to perform business logic and database operations on Good entities.
     *
     * @param service The service handling business logic for Good entities.
     */
    @Autowired
    public GoodController(GoodService service) {
        super(service);
    }

    /**
     * Retrieves a list of Good entities whose names contain the specified substring.
     * This method allows for searching the database for goods based on partial name matches,
     * facilitating user search operations in the application.
     *
     * @param name The substring to search for within Good entity names.
     * @return A list of Good entities that contain the specified substring in their names.
     */
    @GetMapping(value = "/find", produces = "application/json")
    public @ResponseBody List<Good> getEntities(@RequestParam String name) {
        return service.findAllByNameContains(name);
    }
}
