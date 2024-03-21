package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Calculator.Calculator;
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
    public @ResponseBody Calculator.CalculationResponse putPopulationBuildingEntity(
            @RequestParam(name = "goodSlug") String goodSlug
    ) {
        return service.calculate(goodSlug);
    }
}
