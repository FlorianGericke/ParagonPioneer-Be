package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Entity.JoinTables.Population_Requirement;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

/**
 * Entity class representing a population segment within the game.
 * Populations can produce various units or resources, represented by the {@link PopulationProductionUnit} enum.
 * This class includes information about the population name, the slug for URL representation, and relationships with goods and buildings.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "population")
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE population SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Population extends BaseEntity implements Slugable {

    /**
     * Enum defining the possible production units of a population. This includes Militias, Income, and Favor,
     * reflecting the different types of outputs a population can generate.
     */
    public enum PopulationProductionUnit {
        Militias, // Population creates Militias
        Income,   // Population generates Income
        Favor     // Population produces Favor
    }

    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "slug", nullable = false, unique = true,columnDefinition = "varchar(255)")
    private String slug;

    /**
     * Set of goods required by this population to sustain or grow. This is a one-to-many relationship
     * indicating which goods are needed by this population segment.
     */
    @OneToMany(mappedBy = "population")
    @JsonManagedReference
    @ToString.Exclude
    private Set<Population_Requirement> requiredGoods;

    /**
     * Set of buildings required by this population to sustain or grow. This is a one-to-many relationship
     * showing which buildings are needed for this population segment.
     */
    @OneToMany(mappedBy = "population")
    @JsonBackReference
    @ToString.Exclude
    private Set<Requirement_Population_Building> requiredBuilding;

    /**
     * Determines the type of production unit associated with this population based on its name.
     *
     * @return The {@link PopulationProductionUnit} representing the type of production this population contributes to.
     */
    public PopulationProductionUnit getPopulationProductionUnit() {
        if (getName() == null) {
            return null;
        }

        switch (getName()) {
            case "Pioneers":
                return PopulationProductionUnit.Militias;
            case "Paragons":
                return PopulationProductionUnit.Favor;
            default:
                return PopulationProductionUnit.Income;
        }
    }

    /**
     * Retrieves the slug associated with this population.
     * @return The slug as a {@link String}.
     */
    @Override
    public String getSlug() {
        return this.slug;
    }

    /**
     * Sets and validates the slug for this population. If the slug is invalid, an exception is thrown.
     *
     * @param slug The slug to set for this population.
     * @throws IllegalStateException if the slug is invalid as determined by {@link SlugUtil}.
     */
    public void setSlug(String slug) {
        if (!SlugUtil.validateSlug(slug)) {
            throw new IllegalStateException("Could not create Slug for" + slug);
        }

        this.slug = slug;
    }
}
