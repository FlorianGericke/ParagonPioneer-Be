package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatusCode;

public class EntityExistsException extends ParagonPioneerBeException {
    public EntityExistsException(String slug, String name) {
        super(HttpStatusCode.valueOf(409), "Entity Exist Exception: Entity with slug " + slug + " and name " + name + " already exists.");
    }
}
