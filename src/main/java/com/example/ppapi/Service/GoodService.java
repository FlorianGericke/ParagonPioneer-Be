package com.example.ppapi.Service;

import com.example.ppapi.Dto.GoodDTO;
import com.example.ppapi.Entity.Good;
import com.example.ppapi.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value= "goodService")
public class GoodService extends BaseService<Good, GoodRepository, GoodDTO> {

    @Autowired
    public GoodService(GoodRepository repository) {
        super(repository);
    }

    @Override
    public Good post(GoodDTO goodDTO) {
        return repository.save(Good.builder()
                        .name(goodDTO.getName())
                        .remarks(goodDTO.getRemarks())
                .build());
    }

    @Override
    public Good putPatch(Good original, GoodDTO goodDTO) {
        original.setName(goodDTO.getName() != null ? goodDTO.getName() : original.getName());
        original.setRemarks(goodDTO.getRemarks() != null ? goodDTO.getRemarks() : original.getRemarks());
        return original;
    }
}
