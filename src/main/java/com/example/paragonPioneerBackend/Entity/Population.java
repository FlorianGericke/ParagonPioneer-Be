package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.joinTables.PopulationRequirement;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Slugable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "population")
@SQLDelete(sql = "UPDATE population SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor
public class Population extends Slugable {

    /**
     * Enum defining the possible production units of a population. This includes Militias, Income, and Favor,
     * reflecting the different types of outputs a population can generate.
     */
    public enum PopulationProductionUnit {
        Militias, // Population creates Militias
        Income,   // Population generates Income
        Favor     // Population produces Favor
    }

    /**
     * Set of goods required by this population to sustain or grow. This is a one-to-many relationship
     * indicating which goods are needed by this population segment.
     */
    @OneToMany(mappedBy = "population")
    @JsonManagedReference
    @ToString.Exclude
    private Set<PopulationRequirement> requiredGoods;

    /**
     * Set of buildings required by this population to sustain or grow. This is a one-to-many relationship
     * showing which buildings are needed for this population segment.
     */
    @OneToMany(mappedBy = "population")
    @JsonBackReference
    @ToString.Exclude
    private Set<RequirementPopulationBuilding> requiredBuilding;

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

    @Builder
    public Population(String name, String slug, Set<PopulationRequirement> requiredGoods, Set<RequirementPopulationBuilding> requiredBuilding) {
        super(slug, name);
        this.requiredGoods = requiredGoods;
        this.requiredBuilding = requiredBuilding;
    }
}
