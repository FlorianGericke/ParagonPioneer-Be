package com.example.paragonPioneerBackend.Entity.joinTables;

import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Population;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Represents a join table entity that captures the relationship between {@link Population} entities and {@link Good} entities,
 * specifying the goods required by a population segment for consumption or production, as well as identifying basic necessities.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "population_requirement")
@SQLDelete(sql = "UPDATE population_requirement SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class PopulationRequirement extends BaseEntity {

    /**
     * The good associated with the population requirement. This relationship indicates the type of good
     * consumed or produced by the population.
     */
    @ManyToOne()
    @JoinColumn(name = "good_id")
    @JsonManagedReference
    private Good good;

    /**
     * The population that requires or produces the specified good. This forms a many-to-one relationship,
     * as multiple requirements can be associated with a single population segment.
     */
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "population_id")
    private Population population;

    /**
     * The rate at which the population consumes the specified good. This field is used to quantify the consumption
     * needs of the population for the good.
     */
    @Column()
    private float consumption;

    /**
     * The rate at which the population produces the specified good. This field is used to quantify the production
     * output of the population for the good.
     */
    @Column()
    private float produce;

    /**
     * Indicates whether the specified good is considered a basic necessity for the population. This boolean flag
     * helps in identifying essential goods required for the population's survival or well-being.
     */
    @Column()
    private boolean isBasic;
}
