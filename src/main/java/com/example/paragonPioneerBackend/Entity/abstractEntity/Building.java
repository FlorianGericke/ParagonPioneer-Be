package com.example.paragonPioneerBackend.Entity.abstractEntity;

import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Entity.joinTables.RequirementPopulationBuilding;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

/**
 * Represents an abstract base class for different types of buildings within the application.
 * This class extends {@link BaseEntity} to inherit common entity fields and includes specific fields
 * and relationships relevant to buildings, such as name, remarks, costs, population requirements, and a slug for URL representation.
 * It is annotated to support logical deletion and utilizes single table inheritance strategy for subclass entities.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
@Table(name = "building")
@SQLDelete(sql = "UPDATE building SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor
public abstract class Building extends Slugable {

    /**
     * Optional remarks about the building, providing additional information. It is limited to 255 characters.
     */
    @Column(name = "remarks", columnDefinition = "varchar(255)")
    private String remarks;

    /**
     * A collection of costs associated with the building, represented through a join table with building goods.
     * Managed with a bidirectional one-to-many relationship.
     */
    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    private Set<CostBuildingGoods> costs;

    /**
     * The population requirements for the building, represented through a one-to-one relationship.
     * This field is optional and managed bidirectionally.
     */
    @OneToOne(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    private RequirementPopulationBuilding requirePopulation = null;

    public Building(String name, String slug, String remarks, Set<CostBuildingGoods> costs, RequirementPopulationBuilding requirePopulation) {
        super(name, slug);
        this.remarks = remarks;
        this.costs = costs;
        this.requirePopulation = requirePopulation;
    }
}
