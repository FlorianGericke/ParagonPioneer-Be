package com.example.paragonPioneerBackend.Exceptions;

import org.springframework.http.HttpStatus;

public class RequestTimeoutException extends ParagonPioneerApiException {
    public RequestTimeoutException(String reason) {
        super(HttpStatus.REQUEST_TIMEOUT, reason);
    }
}
