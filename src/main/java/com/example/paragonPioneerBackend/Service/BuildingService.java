package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Dto.PopulationBuildingDTO;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.PopulationBuilding;
import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import com.example.paragonPioneerBackend.Repository.PopulationBuildingRepository;
import com.example.paragonPioneerBackend.Repository.ProductionBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component(value = "buildingService")
public class BuildingService<BuildingTypeDTO extends BuildingDTO> extends BaseService<Building, BuildingRepository, BuildingTypeDTO> {

    private final BuildingRepository buildingRepository;

    private final PopulationBuildingRepository populationBuildingRepository;
    private final ProductionBuildingRepository productionBuildingRepository;

    @Autowired
    public BuildingService(BuildingRepository repository, BuildingRepository buildingRepository, PopulationBuildingRepository populationBuildingRepository, ProductionBuildingRepository productionBuildingRepository) {
        super(repository);
        this.buildingRepository = buildingRepository;
        this.populationBuildingRepository = populationBuildingRepository;
        this.productionBuildingRepository = productionBuildingRepository;
    }

    @Override
    public Building post(BuildingTypeDTO buildingTypeDTO) {
        if (buildingTypeDTO instanceof PopulationBuildingDTO populationBuildingDTO) {
            return buildingRepository.save(PopulationBuilding.builder()
                    .name(populationBuildingDTO.getName())
                    .remarks(populationBuildingDTO.getRemarks())
                    .capacity(populationBuildingDTO.getCapacity())
                    .build());
        }

        if (buildingTypeDTO instanceof ProductionBuildingDTO productionBuildingDTO) {
            return buildingRepository.save(PopulationBuilding.builder()
                    .name(productionBuildingDTO.getName())
                    .remarks(productionBuildingDTO.getRemarks())
                    .build());
        }

        return null;
    }

    @Override
    public Building putPatch(Building original, BuildingTypeDTO buildingTypeDTO) {
        original.setName(buildingTypeDTO.getName() != null ? buildingTypeDTO.getName() : original.getName());
        original.setRemarks(buildingTypeDTO.getRemarks() != null ? buildingTypeDTO.getRemarks() : original.getRemarks());

        if (buildingTypeDTO instanceof PopulationBuildingDTO populationBuildingDTO) {
            return original;
        }

        if (buildingTypeDTO instanceof ProductionBuildingDTO productionBuildingDTO) {
            return original;
        }

        return null;
    }

    public List<ProductionBuilding> getAllProductionBuilding() {
        return productionBuildingRepository.findAll();
    }

    public List<PopulationBuilding> getAlPopulationBuilding() {
        return populationBuildingRepository.findAll();
    }
}
