package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.GoodDTO;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * the Base handling the CRUD functions for the Goods Entities. Extends BaseService
 */
@Service(value = "goodService")
public class GoodService extends BaseService<Good, GoodRepository, GoodDTO> {

    /**
     * Constructs a new GoodService. is Autowired
     *
     * @param repository the repository the Service should use
     */
    @Autowired
    public GoodService(GoodRepository repository) {
        super(repository);
    }

    /**
     * Find all Goods with name contains
     *
     * @param name the string contained
     * @return list of Goods matching
     */
    public List<Good> findAllByNameContains(String name) {
        return repository.findAllByNameContains(name);
    }

    /**
     * Find Good by slug
     *
     * @param slug the string contained
     * @return list of Goods matching
     */
    public Optional<Good> findBySlug(String slug) {
        return repository.findBySlugIs(slug);
    }

    /**
     * Find Good by Name
     *
     * @param name the string contained
     * @return list of Goods matching
     */
    public Optional<Good> findByName(String name) {
        return repository.findByNameIs(name);
    }

    /**
     * Adds new Entity to the database
     * Overridden from BaseService
     *
     * @param goodDTO DTO responding to the Entity to add.
     * @return the added entity
     */
    @Override
    public Good post(GoodDTO goodDTO) {
        return repository.save(Good.builder()
                .name(goodDTO.getName())
                .remarks(goodDTO.getRemarks())
                .slug(goodDTO.getSlug().isEmpty() ? SlugUtil.createSlug(goodDTO.getName()) : goodDTO.getSlug())
                .build());
    }

    /**
     * Updates an Entity
     * Overridden from BaseService
     *
     * @param original original entity
     * @param goodDTO  dto containing the updated data
     * @return the updated entity
     */
    @Override
    public Good putPatch(Good original, GoodDTO goodDTO) {
        original.setName(goodDTO.getName() != null ? goodDTO.getName() : original.getName());
        original.setSlug(goodDTO.getSlug() != null ? goodDTO.getSlug() : original.getSlug());
        original.setRemarks(goodDTO.getRemarks() != null ? goodDTO.getRemarks() : original.getRemarks());
        return original;
    }
}
