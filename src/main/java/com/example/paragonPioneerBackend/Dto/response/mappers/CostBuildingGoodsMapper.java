package com.example.paragonPioneerBackend.Dto.response.mappers;

import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The CostBuildingGoodsMapper class is a Spring component that implements the ResponseMapper interface.
 * It is used to map a CostBuildingGoods entity to a CostBuildingGoodsMapper object.
 * Currently, this class is not implemented and serves as a placeholder for future development.
 * The map method, which is required by the ResponseMapper interface, currently returns null.
 */
@Builder
@NoArgsConstructor
@Getter
@Component
public class CostBuildingGoodsMapper implements ResponseMapper<CostBuildingGoodsMapper, CostBuildingGoods> {

    /**
     * This method is used to map a CostBuildingGoods entity to a CostBuildingGoodsMapper object.
     * Currently, this method is not implemented and returns null.
     *
     * @param input The CostBuildingGoods entity to be mapped.
     * @return Currently, this method returns null.
     */
    @Override
    public CostBuildingGoodsMapper map(CostBuildingGoods input) {
        return null;
    }
}