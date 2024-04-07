package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictException extends ParagonPioneerBeException {
    public ConflictException(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}
