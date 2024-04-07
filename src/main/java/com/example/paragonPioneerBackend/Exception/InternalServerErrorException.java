package com.example.paragonPioneerBackend.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InternalServerErrorException extends ParagonPioneerBeException {
    public InternalServerErrorException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }
}
