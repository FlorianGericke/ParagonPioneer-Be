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
 * BaseClass for Buildings
 * Contains all attributes and properties a building has to provide
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
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(name="remarks", columnDefinition = "varchar(255)")
    private String remarks;

    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    private Set<Cost_Building_Goods> costs;

    @OneToOne(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    private Requirement_Population_Building requirePopulation = null;

    @Column(name = "slug", nullable = false, unique = true, columnDefinition = "varchar(255)")
    @ToString.Exclude
    private String slug;

    @Override
    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        if (!SlugUtil.validateSlug(slug)) {
            throw new IllegalStateException("Could not create Slug for" + slug);
        }

        this.slug = slug;
    }
}
