package com.example.paragonPioneerBackend.Controller.abstractController;

import com.example.paragonPioneerBackend.Dto.response.mappers.ResponseMapper;
import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Service.generic.BaseService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This is an abstract base controller class that provides basic CRUD operations for a given entity type.
 * It is parameterized with the following types:
 * - Type: The type of the entity that this controller manages.
 * - Repository: The type of the JpaRepository that this controller uses to interact with the database.
 * - InputDto: The type of the DTO that this controller accepts as input for creating and updating entities.
 * - Mapper: The type of the ResponseMapper that this controller uses to map entities to their corresponding response DTOs.
 * - Service: The type of the BaseService that this controller uses to perform business logic operations.
 * <p>
 * The controller has two protected fields:
 * - service: An instance of the BaseService that this controller uses to perform business logic operations.
 * - mapper: An instance of the ResponseMapper that this controller uses to map entities to their corresponding response DTOs.
 * <p>
 * The controller provides the following endpoints:
 * - POST /: Creates a new entity from the given input DTO and returns the created entity.
 * - GET /: Returns a page of entities, mapped to their corresponding response DTOs.
 * - GET /{id}: Returns the entity with the given ID, mapped to its corresponding response DTO.
 * - PUT /{id}: Updates the entity with the given ID using the given input DTO and returns the updated entity, mapped to its corresponding response DTO.
 * - PATCH /{id}: Partially updates the entity with the given ID using the given input DTO and returns the updated entity, mapped to its corresponding response DTO.
 * - DELETE /{id}: Deletes the entity with the given ID and returns the deleted entity, mapped to its corresponding response DTO.
 */
public abstract class BaseController<
        Type extends BaseEntity,
        Repository extends JpaRepository<Type, UUID>,
        InputDto,
        Mapper extends ResponseMapper<Mapper, Type>,
        Service extends BaseService<Type, Repository, InputDto>
        > {

    protected final Service service;
    protected final Mapper mapper;

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public BaseController(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Creates a new entity based on the provided input DTO.
     *
     * @param dto The input DTO containing data for the new entity.
     * @return The created entity.
     */
    @PostMapping(produces = "application/json")
    public @ResponseBody Mapper postEntity(@RequestBody InputDto dto) {
        return mapper.map(service.post(dto));
    }

    /**
     * Retrieves all entities, paginated according to the provided Pageable object.
     *
     * @param pageable Pagination and sorting information.
     * @return A page of entities, mapped to their corresponding response DTOs.
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody Page<Mapper> getEntities(@ParameterObject Pageable pageable) {
        return service.getAll(pageable).map(mapper::map);
    }

    /**
     * Retrieves a single entity by its ID.
     *
     * @param id The UUID of the entity to retrieve.
     * @return The entity with the specified ID, mapped to its corresponding response DTO.
     */
    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Mapper getEntity(@PathVariable UUID id) {
        return mapper.map(service.get(id));
    }

    /**
     * Updates an entity identified by the given ID with data from the provided input DTO.
     *
     * @param id  The ID of the entity to update.
     * @param dto The input DTO containing updated data.
     * @return The updated entity, mapped to its corresponding response DTO.
     */
    @PutMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Mapper putEntity(@PathVariable UUID id, @RequestBody InputDto dto) {
        return mapper.map(service.put(id, dto));
    }

    /**
     * Partially updates an entity identified by the given ID with data from the provided input DTO.
     *
     * @param id  The ID of the entity to update.
     * @param dto The input DTO containing updated data.
     * @return The updated entity, mapped to its corresponding response DTO.
     */
    @PatchMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Mapper patchEntity(@PathVariable UUID id, @RequestBody InputDto dto) {
        return mapper.map(service.patch(id, dto));
    }

    /**
     * Deletes the entity with the given ID.
     *
     * @param id The UUID of the entity to delete.
     * @return The deleted entity, mapped to its corresponding response DTO.
     */
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Mapper deleteEntity(@PathVariable UUID id) {
        return mapper.map(service.delete(id));
    }
}