package com.example.paragonPioneerBackend.Bin.Config;

import com.example.paragonPioneerBackend.Exception.ParagonPioneerBeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is the GlobalExceptionHandling class.
 * It handles all exceptions thrown across the whole application.
 * It is annotated with @ControllerAdvice, meaning it's a controller where
 * advice (global exception handling, global data binding, and so on) can be provided to all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandling {

    /**
     * This method handles the ParagonPioneerBeException.
     * It takes a ParagonPioneerBeException object and a WebRequest object as parameters.
     * It returns a ResponseEntity with a map containing the details of the exception.
     * It is annotated with @ExceptionHandler, meaning it's a method that handles exceptions.
     * @param ex the ParagonPioneerBeException object
     * @param request the WebRequest object
     * @return ResponseEntity with a map containing the details of the exception
     */
    @ExceptionHandler(ParagonPioneerBeException.class)
    public ResponseEntity<Object> handleMyCustomException(ParagonPioneerBeException ex, WebRequest request) {
        // Create a response body, possibly a Map or a custom error object
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("type", ex.getClass().getSimpleName());
        body.put("message", ex.getMessage());

        // You can add more details to the body as needed
        return new ResponseEntity<>(body, ex.getStatusCode());
    }
}