package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Calculator.CalculationResponse;
import com.example.paragonPioneerBackend.Calculator.Calculator;
import com.example.paragonPioneerBackend.Dto.requests.ProductionBuildingInput;
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
    private final BuildingService<ProductionBuildingInput> productionBuildingDTOBuildingService;

    /**
     * This method calculates the production chain for a given good
     *
     * @param goodSlug the slug of the good to calculate the production chain for
     * @return the result of the calculation
     */
    public CalculationResponse calculate(String goodSlug) {
        Calculator calc = new Calculator(recipeService, goodService, productionBuildingDTOBuildingService);
        return calc.calculate(goodSlug);
    }
}
