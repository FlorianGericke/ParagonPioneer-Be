package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.GoodDTO;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Service.GoodService;
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
