package com.example.paragonPioneerBackend.Controller.abstractController;

import com.example.paragonPioneerBackend.Dto.response.mappers.ResponseMapper;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Slugable;
import com.example.paragonPioneerBackend.Repository.SlugableReposetory;
import com.example.paragonPioneerBackend.Service.generic.SlugableService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This is an abstract controller class that extends the BaseController class and provides additional operations for entities that are Slugable.
 * It is parameterized with the following types:
 * - Type: The type of the Slugable entity that this controller manages.
 * - Repository: The type of the SlugableReposetory that this controller uses to interact with the database.
 * - InputDto: The type of the DTO that this controller accepts as input for creating and updating entities.
 * - Mapper: The type of the ResponseMapper that this controller uses to map entities to their corresponding response DTOs.
 * - Service: The type of the SlugableService that this controller uses to perform business logic operations.
 * <p>
 * The controller provides the following additional endpoints:
 * - GET /: Returns the entity with the given slug, mapped to its corresponding response DTO.
 * - GET /: Returns a set of entities that contain the given name, each mapped to its corresponding response DTO.
 * - GET /: Returns the entity with the given ID, slug, or name, mapped to its corresponding response DTO.
 */
public abstract class SlugableController<
        Type extends Slugable,
        Repository extends SlugableReposetory<Type>,
        InputDto,
        Mapper extends ResponseMapper<Mapper, Type>,
        Service extends SlugableService<Type, Repository, InputDto>
        > extends BaseController<Type, Repository, InputDto, Mapper, Service> {

    /**
     * Constructs a BaseController with the specified service and mapper.
     *
     * @param service The service used for business logic operations.
     * @param mapper  The mapper used for mapping entities to response DTOs.
     */
    public SlugableController(Service service, Mapper mapper) {
        super(service, mapper);
    }

    /**
     * Retrieves an entity by its slug.
     *
     * @param slug The slug of the entity to retrieve.
     * @return The entity with the specified slug.
     */
    @GetMapping(value = "/slug/{slug}", produces = "application/json")
    public @ResponseBody Mapper getEntityBySlug(@PathVariable String slug) {
        return mapper.map(service.findBySlug(slug));
    }

    /**
     * Retrieves all entities that contain the provided string in their name.
     *
     * @param name The string to be searched for in the names of the entities.
     * @return A Set of entities that contain the provided string in their name.
     */
    @GetMapping(value = "/name/{name}", produces = "application/json")
    public @ResponseBody Page<Mapper> getContainingName(@ParameterObject Pageable pageable, @PathVariable String name) {
        return service.findAllContainingName(pageable,name).map(mapper::map);
    }

    /**
     * This method is used to find an entity by its ID, slug, or name.
     * It first tries to parse the provided string as a UUID and find the entity by its ID.
     * If the entity is not found by its ID, it tries to find the entity by its slug.
     * If the entity is still not found, it tries to find the entity by its name.
     * If the entity is not found by its ID, slug, or name, it throws an EntityNotFoundException.
     *
     * @param smth The string that represents the ID, slug, or name of the entity.
     * @return The entity if found by its ID, slug, or name.
     */
    @GetMapping(value = "/find/{smth}", produces = "application/json")
    public @ResponseBody Mapper findByIdSlugName(@PathVariable String smth) {
        return mapper.map(service.findByIdSlugName(smth));
    }
}
