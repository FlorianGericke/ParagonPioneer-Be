package com.example.paragonPioneerBackend.Exceptions;


import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ParagonPioneerApiException {
    public InternalServerErrorException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }
}
