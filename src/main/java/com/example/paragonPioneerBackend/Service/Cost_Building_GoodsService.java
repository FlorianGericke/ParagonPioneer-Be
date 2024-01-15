package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Cost_Building_GoodsDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.Cost_Building_GoodsRepository;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * the Base handling the CRUD functions for the cost building goods relations. Extends BaseService
 */
@Service(value = "costBuildingGoodsService")
public class Cost_Building_GoodsService extends BaseService<Cost_Building_Goods, Cost_Building_GoodsRepository, Cost_Building_GoodsDTO> {
    private final GoodRepository goodRepository;
    private final BuildingRepository buildingRepository;

    /**
     * Constructs a new Cost_Building_GoodsService. is Autowired
     * @param repository the repository the Service should use
     * @param goodRepository the repository the Service should use
     * @param buildingRepository the repository the Service should use
     */
    @Autowired
    public Cost_Building_GoodsService(Cost_Building_GoodsRepository repository, GoodRepository goodRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.buildingRepository = buildingRepository;
    }

    /**
     * Adds new Entity to the database
     * Overridden from BaseService
     * @param costBuildingGoodsDTO DTO responding to the Entity to add.
     * @return the added entity
     */
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

    /**
     * Updates an Entity
     * Overridden from BaseService
     * @param original original entity
     * @param costBuildingGoodsDTO dto containing the updated data
     * @return the updated entity
     */
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
