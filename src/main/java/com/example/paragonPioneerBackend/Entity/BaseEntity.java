package com.example.paragonPioneerBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * BaseClass for entities
 * Contains all attributes and properties the entity has to provide
 */
@MappedSuperclass
public class BaseEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
    private UUID id;

    /**
     * date the entity was created
     */
    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    /**
     * date the entity was last updated
     */
    @Column(name = "updated_at", nullable = true)
    protected LocalDateTime updatedAt;

    /**
     * date the entity was deleted
     */
    @Column(name = "deleted_at", nullable = true)
    protected LocalDateTime deletedAt;


    @PrePersist
    private void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onPreUpdate() {
        if (deletedAt != null) {
            return;
        }
        this.updatedAt = LocalDateTime.now();
    }

    @PreRemove
    private void onPostRemove() {
        this.deletedAt = LocalDateTime.now();
    }

    protected EntityState getState() {
        if(deletedAt != null) {
            return EntityState.DELETED;
        }
        if(updatedAt != null) {
            return EntityState.UPDATED;
        }
        return EntityState.CREATED;
    }
}
