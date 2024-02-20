package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Service.EntityServices.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * The BaseBaseController Handles the Basic CRUD Endpoints.
 *
 * @param <Type>       The Entity for this controller. The entity type must extend from BaseEntity.
 * @param <Repository> The Repository for this controller. The Repository has to extend JpaRepository for the Entity und UUD as identifier
 * @param <Dto>        The Dto for sending data to this controller
 * @param <Service>    the Service handling the CRUD Endpoints
 */
public class BaseController<
        Type extends BaseEntity,
        Repository extends JpaRepository<Type, UUID>,
        Dto,
        Service extends BaseService<Type, Repository, Dto>
        > {

    /**
     * The service this Controller is using
     */
    protected final Service service;

    /**
     * Constructor for the BaseController
     *
     * @param service The service this Controller is using
     */
    public BaseController(Service service) {
        this.service = service;
    }

    /**
     * Post endpoint
     *
     * @param dto entity dto
     * @return the entity added to the database
     */
    @PostMapping(produces = "application/json")
    public @ResponseBody Type postEntity(@RequestBody Dto dto) {
        return service.post(dto);
    }

    /**
     * get endpoint
     *
     * @return a list of all entities
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody Page<Type> getEntities(Pageable pageable) {
        return service.getAll(pageable);
    }

    /**
     * get endpoint
     *
     * @param id uuid of the entity
     * @return entity responding to the uuid
     */
    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Optional<Type> getEntity(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * put endpoint
     *
     * @param id  uuid of the entity to change
     * @param dto dto containing the changes of the entity
     * @return updated entity
     */
    @PutMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type putEntity(@PathVariable UUID id, @RequestBody Dto dto) {
        return service.putPatch(id, dto);
    }

    /**
     * patch endpoint
     *
     * @param id  uuid of the entity to change
     * @param dto dto containing the changes of the entity
     * @return updated entity
     */
    @PatchMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type patchEntity(@PathVariable UUID id, @RequestBody Dto dto) {
        return service.putPatch(id, dto);
    }

    /**
     * delete endpoint
     *
     * @param id uuid of the entity to delete
     * @return deleted entity
     */
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type deleteEntity(@PathVariable UUID id) {
        return service.delete(id);
    }
}
