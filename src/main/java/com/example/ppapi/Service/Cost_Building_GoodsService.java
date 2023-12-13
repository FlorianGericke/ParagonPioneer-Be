package com.example.ppapi.Service;

import com.example.ppapi.Dto.Cost_Building_GoodsDTO;
import com.example.ppapi.Entity.JoinTables.Cost_Building_Goods;
import com.example.ppapi.Repository.BuildingRepository;
import com.example.ppapi.Repository.Cost_Building_GoodsRepository;
import com.example.ppapi.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = " costBuildingGoodsService")
public class Cost_Building_GoodsService extends BaseService<Cost_Building_Goods, Cost_Building_GoodsRepository, Cost_Building_GoodsDTO> {
    private final GoodRepository goodRepository;
    private final BuildingRepository buildingRepository;

    @Autowired
    public Cost_Building_GoodsService(Cost_Building_GoodsRepository repository, GoodRepository goodRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Cost_Building_Goods post(Cost_Building_GoodsDTO costBuildingGoodsDTO) {
        return repository.save(
                Cost_Building_Goods.builder()
                        .good(goodRepository.findById(costBuildingGoodsDTO.getGoodId()).get())
                        .building(buildingRepository.findById(costBuildingGoodsDTO.getBuildingId()).get())
                        .amount(costBuildingGoodsDTO.getAmount())
                        .build()
        );
    }

    @Override
    public Cost_Building_Goods putPatch(Cost_Building_Goods original, Cost_Building_GoodsDTO costBuildingGoodsDTO) {
        original.setBuilding(costBuildingGoodsDTO.getBuildingId() == null ? original.getBuilding() : buildingRepository.findById(costBuildingGoodsDTO.getBuildingId()).get());
        original.setGood(costBuildingGoodsDTO.getGoodId() == null ? original.getGood() : goodRepository.findById(costBuildingGoodsDTO.getGoodId()).get());
        if (original.getAmount() != costBuildingGoodsDTO.getAmount()) {
            original.setAmount(costBuildingGoodsDTO.getAmount());
        }
        return original;
    }
}
