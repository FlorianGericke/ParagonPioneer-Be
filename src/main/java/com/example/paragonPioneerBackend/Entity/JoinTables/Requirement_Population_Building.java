package com.example.paragonPioneerBackend.Entity.JoinTables;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.Population;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Represents a join table entity that links {@link Building} entities with {@link Population} entities to specify
 * the required population amounts necessary for a building. This entity facilitates the expression of dependencies
 * between buildings and the population segments that either support, operate, or are housed within them.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "requirement_population_building")
@SQLDelete(sql = "UPDATE requirement_population_building SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Requirement_Population_Building extends BaseEntity {

    /**
     * The population associated with the building requirement. This many-to-one relationship
     * indicates which population segment is required by the building.
     */
    @ManyToOne()
    @JoinColumn(name = "population_id")
    @JsonManagedReference
    private Population population;

    /**
     * The building that requires a specific population segment. This one-to-one relationship
     * specifies the building dependent on the associated population for operation or habitation.
     */
    @OneToOne()
    @JsonBackReference
    @JoinColumn(name = "building_id")
    private Building building;

    /**
     * The amount of the specified population required by the building. This field quantifies the
     * population requirement, indicating how many individuals or units of the population segment are needed.
     */
    @Column()
    private int amount;
}
