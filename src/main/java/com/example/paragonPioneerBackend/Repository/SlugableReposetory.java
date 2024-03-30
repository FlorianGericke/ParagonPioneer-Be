package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.abstractEntity.Slugable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

/**
 * This interface extends the JpaRepository interface and is used to define custom methods for querying entities that have a slug attribute.
 * It is a generic interface that can be used with any entity that implements the Slugable interface.
 * The interface provides methods for finding entities by their slug and by a substring of their name.
 *
 * @param <SlugableEntity> The entity type that this repository is responsible for. Must extend {@link Slugable}.
 */
@NoRepositoryBean
public interface SlugableReposetory<SlugableEntity extends Slugable> extends JpaRepository<SlugableEntity, UUID> {

    /**
     * This method is used to find a SlugableEntity by its slug.
     * It is a part of the SlugableReposetory interface, which extends JpaRepository.
     * The implementation of this method is provided by Spring Data JPA.
     * If a SlugableEntity with the provided slug is found, it is returned wrapped in an Optional.
     * If no SlugableEntity with the provided slug is found, an empty Optional is returned.
     *
     * @param slug The slug of the SlugableEntity to be found.
     * @return An Optional containing the found SlugableEntity, or an empty Optional if no SlugableEntity was found.
     */
    Optional<SlugableEntity> findBySlug(String slug);

    /**
     * This method is used to find all SlugableEntities that contain the provided name in their name attribute.
     * It is a part of the SlugableReposetory interface, which extends JpaRepository.
     * The implementation of this method is provided by Spring Data JPA.
     * The method returns a List of SlugableEntities that match the criteria.
     * If no SlugableEntity with a name containing the provided string is found, an empty List is returned.
     *
     * @param name The string to be searched for in the names of the SlugableEntities.
     * @return A List of SlugableEntities that contain the provided string in their name.
     */
    Page<SlugableEntity> findAllByNameContains(Pageable pageable, String name);
}