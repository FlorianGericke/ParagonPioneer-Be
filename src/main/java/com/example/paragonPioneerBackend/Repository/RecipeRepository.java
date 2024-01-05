package com.example.paragonPioneerBackend.Repository;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    public Recipe findByOutputIs(Good output);

    public Recipe findByOutputNameIs(String outputName);
}


