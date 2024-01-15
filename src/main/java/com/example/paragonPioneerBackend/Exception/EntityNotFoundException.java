package com.example.paragonPioneerBackend.Exception;


import org.springframework.http.HttpStatusCode;

import java.util.UUID;

public class EntityNotFoundException extends ParagonPioneerBeException {
    public EntityNotFoundException(String reason) {
        super(HttpStatusCode.valueOf(404), reason);
    }


    public EntityNotFoundException(UUID id) {
        this(id.toString());
    }
}
