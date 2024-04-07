package com.example.paragonPioneerBackend.Dto.response.mappers.calculator;

import com.example.paragonPioneerBackend.Calculator.CalculationResponse;
import com.example.paragonPioneerBackend.Dto.response.mappers.ResponseMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * The CalculationMapper class is responsible for mapping a CalculationResponse to a CalculationMapper.
 * It implements the ResponseMapper interface.
 * It is annotated with @Component to indicate that it is a Spring component.
 */
@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculationMapper implements ResponseMapper<CalculationMapper, CalculationResponse> {

    // The recipe represented as a ProductionChainMapper
    private ProductionChainMapper recipe;
    // A list of errors
    private ArrayList<String> errors;

    /**
     * Maps a CalculationResponse to a CalculationMapper.
     * It creates a new ProductionChainMapper and maps the target of the CalculationResponse to it.
     * It then builds a new CalculationMapper with the recipe and the errors from the CalculationResponse.
     *
     * @param input The CalculationResponse to map.
     * @return A new CalculationMapper representing the CalculationResponse.
     */
    @Override
    public CalculationMapper map(CalculationResponse input) {
        return CalculationMapper.builder()
                .recipe(new ProductionChainMapper().map(input.target()))
                .errors(input.errors())
                .build();
    }
}