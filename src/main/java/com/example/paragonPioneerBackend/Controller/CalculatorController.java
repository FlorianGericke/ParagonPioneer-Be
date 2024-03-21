package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.CalculationOutputDTO;
import com.example.paragonPioneerBackend.Service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * This is a Rest Controller class named CalculatorController.
 * It handles the requests for calculations.
 * It uses the CalculatorService to perform the calculations.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/calculator")
public class CalculatorController {

    // The service used to perform calculations
    private final CalculatorService service;

    /**
     * This is a GET mapping that produces a JSON response.
     * It takes a goodSlug as a request parameter and returns a CalculationOutputDTO.
     * The CalculationOutputDTO is the result of the calculation performed by the service.
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody CalculationOutputDTO putPopulationBuildingEntity(
            @RequestParam(name = "goodSlug") String goodSlug
    ) {
        return service.calculate(goodSlug);
    }
}