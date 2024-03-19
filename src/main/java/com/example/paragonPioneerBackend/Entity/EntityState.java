package com.example.paragonPioneerBackend.Entity;

/**
 * Defines the possible states of entities in the application.
 * This enumeration is used to represent the lifecycle state of an entity, such as whether it has been created,
 * updated, or logically deleted (soft delete).
 */
public enum EntityState {
    /**
     * Indicates that the entity has been newly created and not yet modified.
     * This state represents the initial status of an entity after it is persisted for the first time.
     */
    CREATED,

    /**
     * Indicates that the entity has been modified after its initial creation.
     * This state is used to signify that an entity has undergone changes since it was first persisted.
     */
    UPDATED,

    /**
     * Indicates that the entity has been marked as deleted.
     * This state is typically used in systems implementing soft delete functionality, where entities are
     * marked as deleted without being physically removed from the database.
     */
    DELETED
}
