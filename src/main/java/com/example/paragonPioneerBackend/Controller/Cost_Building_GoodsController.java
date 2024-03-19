package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.Cost_Building_GoodsDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Repository.Cost_Building_GoodsRepository;
import com.example.paragonPioneerBackend.Service.Cost_Building_GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing the relationships between costs, buildings, and goods.
 * This controller handles CRUD operations for the cost-building-goods relationship,
 * enabling the management of how goods serve as resources or requirements for buildings.
 * Inherits common CRUD operations from BaseController and utilizes the Cost_Building_GoodsService
 * to perform business logic specific to cost-building-goods relationships.
 */
@RestController
@RequestMapping(path = "/api/v1/cost/building_good")
public class Cost_Building_GoodsController extends BaseController<Cost_Building_Goods, Cost_Building_GoodsRepository, Cost_Building_GoodsDTO, Cost_Building_GoodsService> {

    /**
     * Constructs a new Cost_Building_GoodsController with the specified service.
     * The service is injected by Spring's dependency injection mechanism and is used
     * to perform the necessary CRUD operations on cost-building-goods data.
     *
     * @param service The service handling business logic for cost-building-goods relationships.
     */
    @Autowired
    public Cost_Building_GoodsController(Cost_Building_GoodsService service) {
        super(service);
    }
}
