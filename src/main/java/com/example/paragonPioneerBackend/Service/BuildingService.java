package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "buildingService")
public class BuildingService extends BaseService<Building, BuildingRepository, BuildingDTO> {

    @Autowired
    public BuildingService(BuildingRepository repository) {
        super(repository);
    }

    @Override
    public Building post(BuildingDTO buildingDTO) {
        return repository.save(Building.builder()
                .name(buildingDTO.getName())
                .remarks(buildingDTO.getName())
                .build());
    }

    @Override
    public Building putPatch(Building original, BuildingDTO buildingDTO) {
        original.setName(buildingDTO.getName() != null ? buildingDTO.getName() : original.getName());
        original.setRemarks(buildingDTO.getRemarks() != null ? buildingDTO.getRemarks() : original.getRemarks());
        return original;
    }
}
