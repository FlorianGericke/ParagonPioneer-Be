package com.example.paragonPioneerBackend.Controller;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BaseController<
        Type extends BaseEntity,
        Repository extends JpaRepository<Type, UUID>,
        Dto,
        Service extends BaseService<Type, Repository, Dto>
        > {
    protected final Service service;

    public BaseController(Service service) {
        this.service = service;
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody Type postEntity(@RequestBody Dto dto) {
        return service.post(dto);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody List<Type> getEntities() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Optional<Type> getEntity(@PathVariable UUID id) {
        return service.get(id);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type putEntity(@PathVariable UUID id, @RequestBody Dto dto) {
        return service.putPatch(id, dto);
    }

    @PatchMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type patchEntity(@PathVariable UUID id, @RequestBody Dto dto) {
        return service.putPatch(id, dto);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Type deleteEntity(@PathVariable UUID id) {
        return service.delete(id);
    }
}
