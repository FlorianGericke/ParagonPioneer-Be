package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Entity.JoinTables.Requirement_Population_Building;
import com.example.paragonPioneerBackend.Util.SlugUtil;
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
@AllArgsConstructor
@SQLDelete(sql = "UPDATE building SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor
public abstract class Building extends BaseEntity implements Slugable {

    /**
     * The name of the building. It is a required field and is limited to 255 characters.
     */
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    /**
     * Optional remarks about the building, providing additional information. It is limited to 255 characters.
     */
    @Column(name="remarks", columnDefinition = "varchar(255)")
    private String remarks;

    /**
     * A collection of costs associated with the building, represented through a join table with building goods.
     * Managed with a bidirectional one-to-many relationship.
     */
    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    private Set<Cost_Building_Goods> costs;

    /**
     * The population requirements for the building, represented through a one-to-one relationship.
     * This field is optional and managed bidirectionally.
     */
    @OneToOne(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    private Requirement_Population_Building requirePopulation = null;

    /**
     * A unique slug for the building, used for URL representation. It must be unique and is validated upon setting.
     */
    @Column(name = "slug", nullable = false, unique = true, columnDefinition = "varchar(255)")
    @ToString.Exclude
    private String slug;

    /**
     * Retrieves the slug associated with the building.
     * @return The slug as a {@link String}.
     */
    @Override
    public String getSlug() {
        return this.slug;
    }

    /**
     * Sets and validates the slug for the building. If the slug is invalid, an exception is thrown.
     * @param slug The slug to set for the building.
     * @throws IllegalStateException if the slug is invalid as determined by {@link SlugUtil}.
     */
    public void setSlug(String slug) {
        if (!SlugUtil.validateSlug(slug)) {
            throw new IllegalStateException("Could not create Slug for" + slug);
        }

        this.slug = slug;
    }
}
