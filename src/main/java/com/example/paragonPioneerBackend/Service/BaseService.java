package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The Base Service handling the CRUD functions for the Entities
 * @param <Type> of the Entity the service is for
 * @param <Repository> of the repository the service should use. he Repository has to extend JpaRepository for the Entity und UUD as identifier
 * @param <Dto> containing the data for the Entity
 */
public abstract class BaseService<
        Type extends BaseEntity,
        Repository extends JpaRepository<Type, UUID>,
        Dto
        > {

    /**
     * the repository the Service is using
     */
    protected final Repository repository;

    /**
     * Constructor of the BaseService
     * @param repository the repository the Service is using
     */
    public BaseService(Repository repository) {
        this.repository = repository;
    }

    /**
     * Post function
     * @param dto DTO responding to the Entity to add.
     * @return the created entity
     */
    public abstract Type post(Dto dto);

    /**
     * receive alle entities from the database
     * @return List of entities
     */
    public List<Type> getAll() {
        return repository.findAll();
    }

    /**
     * Get single entity
     * @param id uuid if the entity to receive
     * @return Optional of the Entity
     */
    public Optional<Type> get(UUID id) {
        return repository.findById(id);
    }

    /**
     * Update an entity
     * @param original original entity
     * @param dto dto containing the updated data
     * @return updated entity
     */
    public abstract Type putPatch(Type original, Dto dto);

    /**
     * Update an entity
     * @param id id of the entity to update
     * @param dto dto containing the updated data
     * @return updated entity
     */
    public Type putPatch(UUID id, Dto dto) {
        Type original = repository.findById(id).orElseThrow();
        return repository.save(putPatch(original, dto));
    }

    /**
     * delete an entity
     * @param id of the entity to delete
     * @return deleted entity
     */
    public Type delete(UUID id) {
        Type entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Entity with Id " + id ));
        repository.deleteById(id);
        return entity;
    }
}
