package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.Cost_Building_GoodsDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Repository.Cost_Building_GoodsRepository;
import com.example.paragonPioneerBackend.Service.Cost_Building_GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handling all endpoints responding to the cost building goods relation, extends BaseController.
 *
 */
@RestController
@RequestMapping(path = "/api/v1/cost/building_good")
public class Cost_Building_GoodsController extends BaseController<Cost_Building_Goods, Cost_Building_GoodsRepository, Cost_Building_GoodsDTO, Cost_Building_GoodsService> {

    /**
     * Constructor for Cost_Building_GoodsController, gets autowired
     * @param service service the controller is using
     */
    @Autowired
    public Cost_Building_GoodsController(Cost_Building_GoodsService service) {
        super(service);
    }
}
