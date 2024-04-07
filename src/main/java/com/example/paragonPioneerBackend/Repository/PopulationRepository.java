package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Population;

/**
 * Spring Data JPA repository interface for {@link Population} entities.
 * This repository extends JpaRepository to provide standardized CRUD operations and
 * extends functionality with custom query methods for finding populations by specific criteria.
 * It supports operations such as finding a population by name or slug and searching for populations
 * based on a name substring, enhancing the application's ability to interact with population data.
 */
public interface PopulationRepository extends SlugableReposetory<Population> {
}
