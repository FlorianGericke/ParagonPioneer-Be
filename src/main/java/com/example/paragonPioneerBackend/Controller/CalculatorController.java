package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * A Rest Controller Handling the request for the Calculations
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/calculator")
public class CalculatorController {

    private final CalculatorService service;

    @GetMapping(produces = "application/json")
    public @ResponseBody void putPopulationBuildingEntity(
            @RequestParam(name = "good") String goodName,
            @RequestParam(name = "amount") int amount
    ) {
        service.calculate(goodName, amount);
    }
}
