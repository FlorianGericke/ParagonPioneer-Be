package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Dto.response.mappers.calculator.CalculationMapper;
import com.example.paragonPioneerBackend.Service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * The CalculatorController class is a REST controller that handles requests to the /api/v1/calculator endpoint.
 * It is annotated with @RestController to indicate that it is a Spring REST controller.
 * It is annotated with @RequestMapping to map requests to the /api/v1/calculator endpoint to this controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/calculator")
public class CalculatorController {

    // The CalculatorService that performs the calculations
    private final CalculatorService service;
    // The CalculationMapper that maps CalculationResponses to CalculationMappers
    private final CalculationMapper calculationMapper;

    /**
     * Handles GET requests to the /api/v1/calculator/{goodSlug} endpoint.
     * It uses the CalculatorService to calculate the result for the given goodSlug.
     * It then uses the CalculationMapper to map the CalculationResponse to a CalculationMapper.
     *
     * @param goodSlug The slug of the good for which to calculate the result.
     * @return A CalculationMapper representing the result of the calculation.
     */
    @GetMapping(value = "/{goodSlug}", produces = "application/json")
    public @ResponseBody CalculationMapper putPopulationBuildingEntity(
            @PathVariable String goodSlug) {
        return calculationMapper.map(service.calculate(goodSlug));
    }
}