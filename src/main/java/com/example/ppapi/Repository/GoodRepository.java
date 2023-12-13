package com.example.ppapi.Repository;

import com.example.ppapi.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoodRepository extends JpaRepository<Good, UUID> {
    public Good findByNameIs(String name);
}
