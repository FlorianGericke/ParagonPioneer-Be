package com.example.paragonPioneerBackend.Exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ParagonPioneerApiException extends ResponseStatusException {
    public ParagonPioneerApiException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
