package com.example.paragonPioneerBackend.Dto.response.mappers.calculator;

import com.example.paragonPioneerBackend.Calculator.ProductionKnot;
import com.example.paragonPioneerBackend.Dto.response.mappers.ResponseMapper;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The ProductionChainMapper class is responsible for mapping a ProductionKnot to a ProductionChainMapper.
 * It implements the ResponseMapper interface.
 * It is annotated with @Component to indicate that it is a Spring component.
 */
@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionChainMapper implements ResponseMapper<ProductionChainMapper, ProductionKnot> {

    // The name of the good
    String goodName;
    // The IRI of the good
    String good;
    // The name of the building
    String buildingName;
    // The IRI of the building
    String building;
    // A list of ingredients, each represented as a ProductionChainMapper
    List<ProductionChainMapper> ingredients;

    /**
     * Maps a ProductionKnot to a ProductionChainMapper.
     * If the manufacturer of the ProductionKnot is not null, it gets the name and IRI of the manufacturer.
     * It then builds a new ProductionChainMapper with the name and IRI of the good, the name and IRI of the manufacturer, and a list of ingredients.
     * Each ingredient is mapped to a ProductionChainMapper recursively.
     *
     * @param input The ProductionKnot to map.
     * @return A new ProductionChainMapper representing the ProductionKnot.
     */
    @Override
    public ProductionChainMapper map(ProductionKnot input) {
        String manufacturerName = input.getManufacturer() != null ? input.getManufacturer().getName() : null;
        String manufacturerIri = input.getManufacturer() != null ? UuidUtil.getIri("building/", input.getManufacturer()) : null;

        return ProductionChainMapper.builder()
                .goodName(input.getGood().getName())
                .good(UuidUtil.getIri("good/", input.getGood()))
                .buildingName(manufacturerName)
                .building(manufacturerIri)
                .ingredients(input.getIngredients().stream().map(this::map).toList())
                .build();
    }
}