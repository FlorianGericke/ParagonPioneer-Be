package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for goods
 */
public interface GoodRepository extends JpaRepository<Good, UUID> {

    /**
     * * find a Good by its name
     * @param name of the good to find
     * @return the good
     */
    Optional<Good> findByNameIs(String name);
}
