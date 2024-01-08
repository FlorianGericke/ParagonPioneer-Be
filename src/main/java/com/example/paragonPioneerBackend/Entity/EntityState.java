package com.example.paragonPioneerBackend.Entity;

/**
 * enum of all states an Entity can have
 */
public enum EntityState {
    /**
     * represents an unchanged created entity
     */
    CREATED,

    /**
     * represents a changed entity
     */
    UPDATED,

    /**
     * represents a deleted entity
     */
    DELETED
}
