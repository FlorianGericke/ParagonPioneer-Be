package com.example.paragonPioneerBackend.Exceptions;

import org.springframework.http.HttpStatusCode;

public class EntityNotFoundException extends ParagonPioneerApiException {
    public EntityNotFoundException(String reason) {
        super(HttpStatusCode.valueOf(404), reason);
    }
}
