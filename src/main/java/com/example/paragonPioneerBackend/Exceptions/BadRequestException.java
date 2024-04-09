package com.example.paragonPioneerBackend.Exceptions;

import com.example.paragonPioneerBackend.Exceptions.ParagonPioneerApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ParagonPioneerApiException {
    public BadRequestException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
