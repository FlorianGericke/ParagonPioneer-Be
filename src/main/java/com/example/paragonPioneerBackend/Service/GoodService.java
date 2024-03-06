package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.GoodDTO;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing goods in the application.
 * This class extends the generic BaseService to offer CRUD operations tailored to the Good entity.
 * It utilizes GoodDTO for data transfer and interacts with the GoodRepository for persistence operations.
 */
@Component(value = "goodService")
public class GoodService extends BaseService<Good, GoodRepository, GoodDTO> {

    /**
     * Constructor for GoodService, automatically wired with its repository.
     * Initializes the service with the GoodRepository to interact with the database.
     *
     * @param repository The GoodRepository instance for database operations.
     */
    @Autowired
    public GoodService(GoodRepository repository) {
        super(repository);
    }

    /**
     * Retrieves a list of goods whose names contain the specified string.
     *
     * @param name The substring to search within goods' names.
     * @return A list of Good entities that match the search criteria.
     */
    public List<Good> findAllByNameContains(String name) {
        return repository.findAllByNameContains(name);
    }

    /**
     * Finds a good by its unique slug.
     *
     * @param slug The slug representing the good.
     * @return An Optional containing the Good if found, or an empty Optional otherwise.
     */
    public Optional<Good> findBySlug(String slug) {
        return repository.findBySlugIs(slug);
    }

    /**
     * Finds a good by its exact name.
     *
     * @param name The name of the good to find.
     * @return An Optional containing the Good if found, or an empty Optional otherwise.
     */
    public Optional<Good> findByName(String name) {
        return repository.findByNameIs(name);
    }

    /**
     * Creates a new Good entity based on the provided DTO and saves it to the database.
     *
     * @param goodDTO The DTO containing data for the new Good entity.
     * @return The newly created and saved Good entity.
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
     * Updates an existing Good entity with data from the provided DTO.
     *
     * @param original The original Good entity to update.
     * @param goodDTO  The DTO containing updated data.
     * @return The updated Good entity.
     */
    @Override
    public Good putPatch(Good original, GoodDTO goodDTO) {
        original.setName(goodDTO.getName() != null ? goodDTO.getName() : original.getName());
        original.setSlug(goodDTO.getSlug() != null ? goodDTO.getSlug() : original.getSlug());
        original.setRemarks(goodDTO.getRemarks() != null ? goodDTO.getRemarks() : original.getRemarks());
        return original;
    }
}
