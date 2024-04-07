package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OkStatusException extends ParagonPioneerBeException {
    public OkStatusException(String reason) {
        super(HttpStatus.OK, reason);
    }
}
