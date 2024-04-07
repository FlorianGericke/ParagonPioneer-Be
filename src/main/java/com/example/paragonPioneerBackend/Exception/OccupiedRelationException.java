package com.example.paragonPioneerBackend.Exception;

import org.springframework.http.HttpStatusCode;

/**
 * This class represents a specific type of exception that is thrown when a relation is occupied.
 * It extends from the ParagonPioneerBeException class.
 */
public class OccupiedRelationException extends ParagonPioneerBeException {

    /**
     * Private constructor for the OccupiedRelationException class.
     * It is used to create a new instance of this exception with a specific HTTP status code and reason.
     *
     * @param status The HTTP status code for this exception.
     * @param reason The reason for this exception.
     */
    private OccupiedRelationException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    /**
     * Public constructor for the OccupiedRelationException class.
     * It is used to create a new instance of this exception with a specific reason.
     * The HTTP status code is set to 409 by default.
     *
     * @param reason The reason for this exception.
     */
    public OccupiedRelationException(String reason) {
        this(HttpStatusCode.valueOf(409), reason);
    }
}