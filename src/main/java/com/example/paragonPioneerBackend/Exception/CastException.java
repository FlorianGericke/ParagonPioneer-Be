package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatusCode;

public class CastException extends ParagonPioneerBeException{
    public CastException(String reason) {
        super(HttpStatusCode.valueOf(500), "Cast Exception: " + reason);
    }
}
