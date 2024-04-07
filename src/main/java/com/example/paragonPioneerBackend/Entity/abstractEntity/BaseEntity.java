package com.example.paragonPioneerBackend.Entity.abstractEntity;

import com.example.paragonPioneerBackend.Entity.entityEnums.EntityState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a base class for entities within the application.
 * It includes common attributes such as identifiers and timestamps for creation, update, and deletion.
 * This class serves as a foundation for entity classes, providing essential fields and lifecycle event handling.
 */
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * Unique identifier for the entity. It is generated automatically and is unique across all entities.
     */
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
    private UUID id;

    /**
     * Timestamp indicating when the entity was created. It is set automatically and cannot be null.
     */
    @Column(name = "created_at", nullable = false)
    @Getter
    @Setter
    private LocalDateTime createdAt;

    /**
     * Timestamp indicating the last update time of the entity. It is updated automatically on entity update.
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Timestamp indicating when the entity was marked as deleted. It supports soft delete operation.
     */
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    /**
     * Lifecycle callback method that is invoked before a new entity is persisted.
     * It sets the {@code createdAt} field to the current timestamp.
     */
    @PrePersist
    private void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Lifecycle callback method that is invoked before an entity is updated.
     * It sets the {@code updatedAt} field to the current timestamp unless the entity is marked as deleted.
     */
    @PreUpdate
    private void onPreUpdate() {
        if (deletedAt != null) {
            return;
        }
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Lifecycle callback method that is invoked before an entity is removed.
     * It sets the {@code deletedAt} field to the current timestamp, supporting the soft delete mechanism.
     */
    @PreRemove
    private void onPostRemove() {
        this.deletedAt = LocalDateTime.now();
    }

    /**
     * Determines the current state of the entity based on its timestamps.
     *
     * @return {@link EntityState} indicating whether the entity is created, updated, or deleted.
     */
    protected EntityState getState() {
        if (deletedAt != null) {
            return EntityState.DELETED;
        }
        if (updatedAt != null) {
            return EntityState.UPDATED;
        }
        return EntityState.CREATED;
    }
}