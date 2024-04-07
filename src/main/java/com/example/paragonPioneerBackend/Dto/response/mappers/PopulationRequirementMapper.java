package com.example.paragonPioneerBackend.Dto.response.mappers;

import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The PopulationRequirementMapper class is a Spring component that implements the ResponseMapper interface.
 * It is used to map a PopulationRequirement entity to a PopulationRequirementMapper object.
 * Currently, this class is not implemented and serves as a placeholder for future development.
 * The map method, which is required by the ResponseMapper interface, currently returns null.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class PopulationRequirementMapper implements ResponseMapper<PopulationRequirementMapper, PopulationRequirement>
{
    private String id;
    @Builder.Default
    private String good = null;
    @Builder.Default
    private String population = null;
    @Builder.Default
    private Float consumption = null;
    @Builder.Default
    private Float produceRate = null;
    @Builder.Default
    private boolean isBasic = true;

    /**
     * This method is used to map a PopulationRequirement entity to a PopulationRequirementMapper object.
     * Currently, this method is not implemented and returns null.
     *
     * @param input The PopulationRequirement entity to be mapped.
     * @return Currently, this method returns null.
     */
    @Override
    public PopulationRequirementMapper map(PopulationRequirement input) {
        return PopulationRequirementMapper.builder()
                .id(UuidUtil.getIri("requirement/population/",input))
                .good(UuidUtil.getIri("good/",input.getGood()))
                .population(UuidUtil.getIri("population/",input.getPopulation()))
                .consumption(input.getConsumption())
                .produceRate(input.getProduce())
                .isBasic(input.isBasic())
                .build();
    }
}