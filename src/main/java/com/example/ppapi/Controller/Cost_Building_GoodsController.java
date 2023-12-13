package com.example.ppapi.Controller;

import com.example.ppapi.Dto.Cost_Building_GoodsDTO;
import com.example.ppapi.Entity.JoinTables.Cost_Building_Goods;
import com.example.ppapi.Repository.Cost_Building_GoodsRepository;
import com.example.ppapi.Service.Cost_Building_GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/cost/building_good")
public class Cost_Building_GoodsController extends BaseController<Cost_Building_Goods, Cost_Building_GoodsRepository, Cost_Building_GoodsDTO, Cost_Building_GoodsService> {

    @Autowired
    public Cost_Building_GoodsController(Cost_Building_GoodsService service) {
        super(service);
    }
}
