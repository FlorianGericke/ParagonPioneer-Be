package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Calculator.Calculator;
import com.example.paragonPioneerBackend.Calculator.ProductionKnot;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.EntityServices.BuildingService;
import com.example.paragonPioneerBackend.Service.EntityServices.GoodService;
import com.example.paragonPioneerBackend.Service.EntityServices.RecipeService;
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

    public void calculate(String goodName, float amount) {
        Calculator calc = new Calculator(recipeService, goodService, goodName, amount, productionBuildingDTOBuildingService);
        System.out.println(calc.getFormatted());
    }
}
