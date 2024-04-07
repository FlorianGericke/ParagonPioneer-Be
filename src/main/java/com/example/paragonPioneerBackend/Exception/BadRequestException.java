package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ParagonPioneerBeException {
    public BadRequestException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
