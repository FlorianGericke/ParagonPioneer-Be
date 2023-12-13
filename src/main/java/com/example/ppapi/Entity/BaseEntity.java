package com.example.ppapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
public class BaseEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true)
    protected LocalDateTime deletedAt;


    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        if (deletedAt != null) {
            return;
        }
        this.updatedAt = LocalDateTime.now();
    }

    @PreRemove
    public void onPostRemove() {
        this.deletedAt = LocalDateTime.now();
    }

    public EntityState getState() {
        if(deletedAt != null) {
            return EntityState.DELETED;
        }
        if(updatedAt != null) {
            return EntityState.UPDATED;
        }
        return EntityState.CREATED;
    }
}
