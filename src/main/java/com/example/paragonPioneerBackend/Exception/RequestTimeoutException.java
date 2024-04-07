package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RequestTimeoutException extends ParagonPioneerBeException {
    public RequestTimeoutException(String reason) {
        super(HttpStatus.REQUEST_TIMEOUT, reason);
    }
}
