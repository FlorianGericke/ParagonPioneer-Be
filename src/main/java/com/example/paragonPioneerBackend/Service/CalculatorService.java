package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Calculator.Calculator;
import com.example.paragonPioneerBackend.Calculator.ProductionKnot;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service responsible for all calculations of the production chain
 */
@RequiredArgsConstructor
@Service(value = "calculatorService")
public class CalculatorService {

    private final RecipeRepository recipeRepository;
    private final GoodRepository goodRepository;

    public void calculate(String goodName, float amount){
        Calculator calc = new Calculator(recipeRepository, goodRepository, new ProductionKnot(goodName,amount));
        System.out.println(calc.getFormatted());
    }
}
