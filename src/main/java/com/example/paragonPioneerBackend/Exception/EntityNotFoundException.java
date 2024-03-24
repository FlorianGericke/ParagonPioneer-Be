package com.example.paragonPioneerBackend.Exception;


import org.springframework.http.HttpStatusCode;

import java.util.UUID;

public class EntityNotFoundException extends ParagonPioneerBeException {
    public EntityNotFoundException(String identifier, String value) {
        super(HttpStatusCode.valueOf(404), "No Entity with " + identifier + " \"" + value + "\" found");
    }

    public EntityNotFoundException(UUID id) {
        this("id", id.toString());
    }
}
