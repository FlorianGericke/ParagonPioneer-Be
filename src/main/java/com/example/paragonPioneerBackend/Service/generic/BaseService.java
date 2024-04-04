package com.example.paragonPioneerBackend.Service.generic;

import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Util.UuidUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Abstract base service class providing CRUD functionalities for entities.
 * This class encapsulates common service layer operations, offering a foundation for entity-specific services.
 * It leverages Spring Data JPA repositories for database interactions.
 *
 * @param <Type>       The entity type this service is responsible for. Must extend BaseEntity.
 * @param <Repository> The JPA repository type used by this service. Must extend JpaRepository.
 * @param <Dto>        The data transfer object (DTO) type used for transferring data between processes.
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
     * @param dto The DTO containing data for the new entity.
     * @return The created entity.
     */
    @Transactional
    public Type post(Dto dto) {
        return repository.saveAndFlush(mapToEntity(dto));
    }

    @Transactional
    public abstract Type mapToEntity(Dto dto);

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
     * Retrieves a single entity by its ID.
     *
     * @param id The UUID of the entity to retrieve.
     * @return An Optional containing the entity if found, or empty otherwise.
     */
    public Type get(UUID id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    /**
     * Updates an existing entity with the provided DTO.
     *
     * @param id  The UUID of the entity to update.
     * @param dto The DTO containing the updated data for the entity.
     * @return The updated entity.
     * @throws EntityNotFoundException if the entity with the provided ID is not found in the repository.
     */
    @Transactional
    public Type put(UUID id, Dto dto) throws EntityNotFoundException {
        var old = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Type next = mapToEntity(dto);
        next.setId(id);
        next.setCreatedAt(old.getCreatedAt());
        return repository.saveAndFlush(next);
    }

    /**
     * This method is used to patch an existing entity with the provided DTO.
     * It first retrieves the original entity from the repository using the provided ID.
     * If the entity is not found, it throws an EntityNotFoundException.
     * It then calls the abstract patch method, passing the original entity and the DTO.
     * The result of the patch method, which should be the patched entity, is then saved back to the repository.
     *
     * @param id  The UUID of the entity to be patched.
     * @param dto The DTO containing the changes to be applied to the original entity.
     * @return The patched and saved entity.
     * @throws EntityNotFoundException if the entity with the provided ID is not found in the repository.
     */
    @Transactional
    public Type patch(UUID id, Dto dto) throws EntityNotFoundException {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        var entity = repository.getReferenceById(id);
        return repository.saveAndFlush(patch(entity, dto));
    }

    /**
     * This method is used to patch an existing entity with the provided DTO.
     * It is an abstract method, meaning it must be implemented in any class that extends BaseService.
     * The implementation should handle merging the original entity with the changes defined in the DTO.
     *
     * @param entityToUpdate The original entity that is to be patched.
     * @param dto            The DTO containing the changes to be applied to the original entity.
     * @return The patched entity.
     */
    @Transactional
    public abstract Type patch(Type entityToUpdate, Dto dto);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The UUID of the entity to delete.
     * @return The deleted entity.
     */
    @Transactional
    public Type delete(UUID id) throws EntityNotFoundException {
        Type entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
        return entity;
    }

    /**
     * This method is used to retrieve an entity by its ID or IRI.
     * It first tries to parse the provided string as a UUID. If this fails, it assumes the string is an IRI.
     * It then extracts the UUID from the IRI and tries to parse it.
     * If the parsing is successful, it uses the parsed UUID to retrieve the entity from the repository.
     * If the entity is not found, it throws an EntityNotFoundException.
     *
     * @param idOrIri The ID or IRI of the entity to retrieve.
     * @return The retrieved entity.
     * @throws EntityNotFoundException if the entity with the provided ID or IRI is not found in the repository.
     */
    public Type getByIdOrIri(String idOrIri) {
        return repository.findById(UuidUtil.getFromString(idOrIri)).orElseThrow(() -> new EntityNotFoundException(UuidUtil.getFromString(idOrIri)));
    }
}