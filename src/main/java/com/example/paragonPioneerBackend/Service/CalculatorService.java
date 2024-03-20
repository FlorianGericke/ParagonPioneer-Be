//package com.example.paragonPioneerBackend.Service;
//
//import com.example.paragonPioneerBackend.Calculator.Calculator;
//import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
///**
// * Service responsible for all calculations of the production chain
// */
//@RequiredArgsConstructor
//@Service(value = "calculatorService")
//public class CalculatorService {
//
//    private final RecipeService recipeService;
//    private final GoodService goodService;
//    private final BuildingService<ProductionBuildingDTO> productionBuildingDTOBuildingService;
//
//    public void calculate(String goodName, float amount) {
//        Calculator calc = new Calculator(recipeService, goodService, goodName, amount, productionBuildingDTOBuildingService);
//        System.out.println(calc.getFormatted());
//    }
//}
