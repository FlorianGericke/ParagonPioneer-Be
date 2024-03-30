package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Controller.abstractController.BaseController;
import com.example.paragonPioneerBackend.Dto.requests.CostBuildingGoodsInput;
import com.example.paragonPioneerBackend.Dto.response.mappers.CostBuildingGoodsMapper;
import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Repository.CostBuildingGoodsRepository;
import com.example.paragonPioneerBackend.Service.CostBuildingGoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CostBuildingGoodsController is a REST controller that manages the relationships between costs, buildings, and goods.
 * It extends the BaseController and provides CRUD operations for the cost-building-goods relationship.
 * This enables the management of how goods serve as resources or requirements for buildings.
 *
 * The CostBuildingGoodsController class is parameterized with the following types:
 * - CostBuildingGoods: The entity type that this controller handles.
 * - CostBuildingGoodsRepository: The repository type used for accessing the database.
 * - CostBuildingGoodsInput: The DTO type used for creating and updating cost-building-goods relationships.
 * - CostBuildingGoodsMapper: The mapper type used for converting between entities and DTOs.
 * - CostBuildingGoodsService: The service type used for business logic operations.
 */
@RestController
@RequestMapping(path = "/api/v1/cost/building-good")
public class CostBuildingGoodsController extends BaseController<CostBuildingGoods, CostBuildingGoodsRepository, CostBuildingGoodsInput, CostBuildingGoodsMapper, CostBuildingGoodsService> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public CostBuildingGoodsController(CostBuildingGoodsService service, CostBuildingGoodsMapper mapper) {
        super(service, mapper);
    }
}