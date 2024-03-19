package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.Cost_Building_GoodsDTO;
import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.Cost_Building_GoodsRepository;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service class for managing the relationships between buildings and goods within the application.
 * This class extends the BaseService to offer specialized CRUD operations for the Cost_Building_Goods entity.
 * It interacts with the GoodRepository and BuildingRepository to handle operations related to building costs and goods.
 */
@Service(value = "costBuildingGoodsService")
public class Cost_Building_GoodsService extends BaseService<Cost_Building_Goods, Cost_Building_GoodsRepository, Cost_Building_GoodsDTO> {
    private final GoodRepository goodRepository;
    private final BuildingRepository buildingRepository;

    /**
     * Autowired constructor to inject repository dependencies. Initializes the service with necessary repositories.
     *
     * @param repository The primary repository for Cost_Building_Goods entities.
     * @param goodRepository Repository for Good entities, enabling lookups of goods by ID.
     * @param buildingRepository Repository for Building entities, enabling lookups of buildings by ID.
     */
    @Autowired
    public Cost_Building_GoodsService(Cost_Building_GoodsRepository repository, GoodRepository goodRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.buildingRepository = buildingRepository;
    }

    /**
     * Creates and saves a new Cost_Building_Goods entity based on the provided DTO.
     *
     * @param costBuildingGoodsDTO The DTO containing the data for the new Cost_Building_Goods entity.
     * @return The newly created and saved Cost_Building_Goods entity.
     */
    @Override
    public Cost_Building_Goods post(Cost_Building_GoodsDTO costBuildingGoodsDTO) {
        return repository.save(
                Cost_Building_Goods.builder()
                        .good(goodRepository.findById(UUID.fromString(costBuildingGoodsDTO.getGoodId())).orElse(null))
                        .building(buildingRepository.findById(UUID.fromString(costBuildingGoodsDTO.getBuildingId())).orElse(null))
                        .amount(costBuildingGoodsDTO.getAmount())
                        .build()
        );
    }

    /**
     * Updates an existing Cost_Building_Goods entity with data from the provided DTO.
     * Allows for updating the related good, building, and the amount of goods required.
     *
     * @param original The original Cost_Building_Goods entity to be updated.
     * @param costBuildingGoodsDTO The DTO containing updated data.
     * @return The updated Cost_Building_Goods entity.
     */
    @Override
    public Cost_Building_Goods putPatch(Cost_Building_Goods original, Cost_Building_GoodsDTO costBuildingGoodsDTO) {
        original.setBuilding(costBuildingGoodsDTO.getBuildingId() == null ? original.getBuilding() : buildingRepository.findById(UUID.fromString(costBuildingGoodsDTO.getBuildingId())).get());
        original.setGood(costBuildingGoodsDTO.getGoodId() == null ? original.getGood() : goodRepository.findById(UUID.fromString(costBuildingGoodsDTO.getGoodId())).get());
        if (original.getAmount() != costBuildingGoodsDTO.getAmount()) {
            original.setAmount(costBuildingGoodsDTO.getAmount());
        }
        return original;
    }
}
