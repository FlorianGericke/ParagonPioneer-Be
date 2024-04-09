package com.example.paragonPioneerBackend.Exceptions;

import org.springframework.http.HttpStatus;

public class OkStatusException extends ParagonPioneerApiException {
    public OkStatusException(String reason) {
        super(HttpStatus.OK, reason);
    }
}
