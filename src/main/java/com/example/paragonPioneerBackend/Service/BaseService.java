package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public abstract class BaseService<
        Type extends BaseEntity,
        Repository extends JpaRepository<Type, UUID>,
        Dto
        > {
    protected final Repository repository;

    public BaseService(Repository repository) {
        this.repository = repository;
    }

    //    Create
    public abstract Type post(Dto dto);


    //    Read
    public List<Type> getAll() {
        return repository.findAll();
    }

    public Optional<Type> get(UUID id) {
        return repository.findById(id);
    }

    public abstract Type putPatch(Type original, Dto dto);

    //    Update
    public Type putPatch(UUID id, Dto dto) {
        Type original = repository.findById(id).orElseThrow();
        return repository.save(putPatch(original, dto));
    }

    //    Delete
    public Type delete(UUID id) {
        Type entity = repository.findById(id).orElseThrow();
        repository.deleteById(id);
        return entity;
    }
}
