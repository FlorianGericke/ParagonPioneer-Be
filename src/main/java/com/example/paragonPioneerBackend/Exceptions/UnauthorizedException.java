package com.example.paragonPioneerBackend.Exceptions;

import com.example.paragonPioneerBackend.Exceptions.ParagonPioneerApiException;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ParagonPioneerApiException {
    public UnauthorizedException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }
}
