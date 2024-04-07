package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.CostBuildingGoodsInput;
import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.CostBuildingGoodsRepository;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Service.generic.BaseService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing the relationships between buildings and goods within the application.
 * This class extends the BaseService to offer specialized CRUD operations for the Cost_Building_Goods entity.
 * It interacts with the GoodRepository and BuildingRepository to handle operations related to building costs and goods.
 */
@org.springframework.stereotype.Service()
public class CostBuildingGoodsService extends BaseService<CostBuildingGoods, CostBuildingGoodsRepository, CostBuildingGoodsInput> {
    private final GoodRepository goodRepository;
    private final BuildingRepository buildingRepository;

    /**
     * Autowired constructor to inject repository dependencies. Initializes the service with necessary repositories.
     *
     * @param repository         The primary repository for Cost_Building_Goods entities.
     * @param goodRepository     Repository for Good entities, enabling lookups of goods by ID.
     * @param buildingRepository Repository for Building entities, enabling lookups of buildings by ID.
     */
    @Autowired
    public CostBuildingGoodsService(CostBuildingGoodsRepository repository, GoodRepository goodRepository, BuildingRepository buildingRepository) {
        super(repository);
        this.goodRepository = goodRepository;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public CostBuildingGoods mapToEntity(CostBuildingGoodsInput costBuildingGoodsDTO) {
        return null;
    }

    /**
     * This method is used to update the properties of a Cost_Building_Goods entity based on the provided DTO.
     * It updates the building, good, and amount of the entity to update.
     * The building and good are updated using the PatchUtil.patchHelper method, which checks if the new value is null.
     * If the new value is not null, it replaces the old value. If it is null, the old value is kept.
     * The amount is updated directly from the DTO.
     *
     * @param entityToUpdate       The original Cost_Building_Goods entity that might be updated.
     * @param costBuildingGoodsDTO The DTO that contains the new values for the Cost_Building_Goods entity.
     * @return The updated Cost_Building_Goods entity.
     */
    @Override
    @Transactional
    public CostBuildingGoods patch(CostBuildingGoods entityToUpdate, CostBuildingGoodsInput costBuildingGoodsDTO) {
        entityToUpdate.setBuilding(ServiceUtil.patchHelper(entityToUpdate.getBuilding(), costBuildingGoodsDTO.getBuilding(), buildingRepository));
        entityToUpdate.setGood(ServiceUtil.patchHelper(entityToUpdate.getGood(), costBuildingGoodsDTO.getGood(), goodRepository));
        entityToUpdate.setAmount(ServiceUtil.patchHelper(entityToUpdate.getAmount(), costBuildingGoodsDTO.getAmount()));
        return entityToUpdate;
    }

    /**
     * Creates and saves a new Cost_Building_Goods entity based on the provided DTO.
     *
     * @param costBuildingGoodsDTO The DTO containing the data for the new Cost_Building_Goods entity.
     * @return The newly created and saved Cost_Building_Goods entity.
     */
    @Override
    @Transactional
    public CostBuildingGoods post(CostBuildingGoodsInput costBuildingGoodsDTO) {
        return repository.save(
                CostBuildingGoods.builder()
                        .good(ServiceUtil.getHelper(costBuildingGoodsDTO.getGood(), goodRepository))
                        .building(ServiceUtil.getHelper(costBuildingGoodsDTO.getBuilding(), buildingRepository))
                        .amount(costBuildingGoodsDTO.getAmount())
                        .build()
        );
    }
}