package com.example.paragonPioneerBackend.Exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends ParagonPioneerApiException {
    public ConflictException(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}
