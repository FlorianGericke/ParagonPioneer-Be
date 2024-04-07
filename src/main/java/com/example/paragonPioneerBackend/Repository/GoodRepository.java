package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;

/**
 * Spring Data JPA repository for {@link Good} entities.
 * This interface provides automated CRUD functionalities for goods,
 * leveraging the JpaRepository interface from Spring Data. Additional methods
 * are defined for querying goods by exact names, slugs, or name substrings,
 * enhancing the application's ability to access and manage good data efficiently.
 */
public interface GoodRepository extends SlugableReposetory<Good> {
}
