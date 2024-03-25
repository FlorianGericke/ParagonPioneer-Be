package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Abstract base service class providing CRUD functionalities for entities.
 * This class encapsulates common service layer operations, offering a foundation for entity-specific services.
 * It leverages Spring Data JPA repositories for database interactions.
 *
 * @param <Type> The entity type this service is responsible for. Must extend BaseEntity.
 * @param <Repository> The JPA repository type used by this service. Must extend JpaRepository.
 * @param <Dto> The data transfer object (DTO) type used for transferring data between processes.
 */
public abstract class BaseService<Type extends BaseEntity, Repository extends JpaRepository<Type, UUID>, Dto> {

    /**
     * Repository instance used for database operations.
     */
    protected final Repository repository;

    /**
     * Constructs a BaseService with the specified repository.
     *
     * @param repository The repository used for database operations.
     */
    public BaseService(Repository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new entity based on the provided DTO.
     *
     * @param dto DTO representing the data for the new entity.
     * @return The newly created entity.
     */
    public abstract Type post(Dto dto);

    /**
     * Retrieves all entities, paginated according to the provided Pageable object.
     *
     * @param pageable Pagination and sorting information.
     * @return A page of entities.
     */
    public Page<Type> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Retrieves all entities, with pagination and sorting based on page number and page size.
     *
     * @param page The page number to retrieve.
     * @param pageSize The number of entities per page.
     * @return A page of entities.
     */
    public Page<Type> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    /**
     * Retrieves a single entity by its ID.
     *
     * @param id The UUID of the entity to retrieve.
     * @return An Optional containing the entity if found, or empty otherwise.
     */
    public Type get(UUID id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    /**
     * Updates an existing entity with data from the provided DTO.
     * This method must be implemented by subclasses to define entity-specific update logic.
     *
     * @param original The original entity to update.
     * @param dto The DTO containing updated data.
     * @return The updated entity.
     */
    public abstract Type putPatch(Type original, Dto dto);

    /**
     * Updates an entity identified by the given ID with data from the provided DTO.
     *
     * @param id The ID of the entity to update.
     * @param dto The DTO containing updated data.
     * @return The updated entity.
     */
    public Type putPatch(UUID id, Dto dto) throws EntityNotFoundException {
        Type original = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return repository.save(putPatch(original, dto));
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id The UUID of the entity to delete.
     * @return The deleted entity.
     */
    public Type delete(UUID id) throws EntityNotFoundException {
        Type entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
        return entity;
    }
}
