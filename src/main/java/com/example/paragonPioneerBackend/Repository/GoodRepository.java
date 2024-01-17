package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for goods
 */
public interface GoodRepository extends JpaRepository<Good, UUID> {

    /**
     * * find a Good by its name
     *
     * @param name of the good to find
     * @return the good
     */
    Good findByNameIs(String name);

    /**
     * find all goods by name contains
     *
     * @param name contained string
     * @return list of all matching
     */
    List<Good> findAllByNameContains(String name);
}
