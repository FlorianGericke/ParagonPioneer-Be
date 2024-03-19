package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * Generic base controller class that handles basic CRUD operations for a specified entity type.
 * Utilizes Spring Web's RESTful controller annotations to map HTTP requests to corresponding service layer methods.
 *
 * @param <Type>       The type of the entity this controller handles. Must extend {@link BaseEntity}.
 * @param <Repository> The JPA repository associated with the entity. Must extend {@link JpaRepository}.
 * @param <Dto>        The Data Transfer Object (DTO) type used for transferring data to and from the controller.
 * @param <Service>    The service type that provides CRUD operations for the entity.
 */
public class BaseController<
        Type extends BaseEntity,
        Repository extends JpaRepository<Type, UUID>,
        Dto,
        Service extends BaseService<Type, Repository, Dto>
        > {

    protected final Service service;

    /**
     * Constructs a BaseController with the specified service.
     *
     * @param service The service handling the CRUD operations for the entity.
     */
    public BaseController(Service service) {
        this.service = service;
    }

    /**
     * Creates a new entity based on the provided DTO.
     *
     * @param dto The DTO containing the data to create a new entity.
     * @return The created entity.
     */
    @PostMapping(produces = "application/json")
    public @ResponseBody Type postEntity(@RequestBody Dto dto) {
        return service.post(dto);
    }

    /**
     * Retrieves a page of entities.
     *
     * @param pageable Pagination and sorting information.
     * @return A page of entities.
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody Page<Type> getEntities(Pageable pageable) {
        return service.getAll(pageable);
    }

    /**
     * Retrieves a specific entity by its UUID.
     *
     * @param id The UUID of the entity to retrieve.
     * @return An Optional containing the entity if found, or empty otherwise.
     */
    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Optional<Type> getEntity(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Updates an existing entity with the provided DTO data.
     *
     * @param id  The UUID of the entity to update.
     * @param dto The DTO containing the updated data.
     * @return The updated entity.
     */
    @PutMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type putEntity(@PathVariable UUID id, @RequestBody Dto dto) {
        return service.putPatch(id, dto);
    }

    /**
     * Partially updates an existing entity with the provided DTO data.
     *
     * @param id  The UUID of the entity to update.
     * @param dto The DTO containing the changes.
     * @return The updated entity.
     */
    @PatchMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type patchEntity(@PathVariable UUID id, @RequestBody Dto dto) {
        return service.putPatch(id, dto);
    }

    /**
     * Deletes an existing entity by its UUID.
     *
     * @param id The UUID of the entity to delete.
     * @return The deleted entity.
     */
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type deleteEntity(@PathVariable UUID id) {
        return service.delete(id);
    }
}
