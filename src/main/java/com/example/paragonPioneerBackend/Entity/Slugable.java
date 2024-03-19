package com.example.paragonPioneerBackend.Entity;

/**
 * Defines the contract for entities that can be identified by a slug.
 * A slug is a URL-friendly string identifier that represents an entity in URLs, making them readable and SEO-friendly.
 * This interface ensures that any implementing class will provide a method to retrieve its slug.
 */
public interface Slugable {

    /**
     * Retrieves the slug of the entity.
     * The slug is intended to be used in URL paths, making them more readable and SEO-friendly.
     *
     * @return The slug as a {@link String}.
     */
    String getSlug();
}
