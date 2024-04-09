package com.example.paragonPioneerBackend.Entity.abstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Defines the contract for entities that can be identified by a slug.
 * A slug is a URL-friendly string identifier that represents an entity in URLs, making them readable and SEO-friendly.
 * This interface ensures that any implementing class will provide a method to retrieve its slug.
 */
@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class Slugable extends BaseEntity {

    @Column(name = "name", nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "slug", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String slug;

    public Slugable(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }
}
