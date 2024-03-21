package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Calculator.Calculator;
import com.example.paragonPioneerBackend.Dto.CalculationOutputDTO;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service responsible for all calculations of the production chain
 */
@RequiredArgsConstructor
@Service(value = "calculatorService")
public class CalculatorService {

    private final RecipeService recipeService;
    private final GoodService goodService;
    private final BuildingService<ProductionBuildingDTO> productionBuildingDTOBuildingService;

    /**
     * This method calculates the production chain for a given good
     * @param goodSlug the slug of the good to calculate the production chain for
     * @return the result of the calculation
     */
    public CalculationOutputDTO calculate(String goodSlug) {
        Calculator calc = new Calculator(recipeService, goodService, productionBuildingDTOBuildingService);
        return CalculationOutputDTO.createFromEntity(calc.calculate(goodSlug));
    }
}
