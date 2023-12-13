package com.example.ppapi.Controller;

import com.example.ppapi.Dto.GoodDTO;
import com.example.ppapi.Entity.Good;
import com.example.ppapi.Repository.GoodRepository;
import com.example.ppapi.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/api/v1/good")
public class GoodController extends BaseController<Good, GoodRepository, GoodDTO, GoodService> {

    @Autowired
    public GoodController(GoodService service) {
        super(service);
    }
}
