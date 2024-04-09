package com.example.paragonPioneerBackend.Exceptions;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import org.springframework.http.HttpStatusCode;

import java.util.UUID;

public class EntityNotFoundException extends ParagonPioneerApiException {
    public EntityNotFoundException(UUID id) {
        super(HttpStatusCode.valueOf(404), "No Entity with id" + id.toString() + " found");
    }

    public EntityNotFoundException(String name) {
        super(HttpStatusCode.valueOf(404), "No Entity with name" + name + " found");
    }
}