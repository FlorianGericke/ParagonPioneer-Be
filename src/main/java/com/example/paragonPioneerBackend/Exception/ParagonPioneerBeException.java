package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ParagonPioneerBeException extends ResponseStatusException {
    public ParagonPioneerBeException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
