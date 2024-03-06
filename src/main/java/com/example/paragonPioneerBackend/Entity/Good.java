package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

/**
 * Represents a good within the application.
 * Goods are essential entities used within the application, associated with buildings and their construction or usage.
 * This class extends {@link BaseEntity} and implements {@link Slugable} to ensure it has a unique identifier and supports URL-friendly identifiers.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "good")
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE good SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Good extends BaseEntity implements Slugable {

    /**
     * The name of the good. It is unique and cannot be null, ensuring that each good can be distinctly identified.
     */
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String name;

    /**
     * Optional remarks providing additional information about the good. It can be null and provides flexibility in describing the good.
     */
    @Column(name = "remarks", nullable = true, columnDefinition = "varchar(255)")
    private String remarks;

    /**
     * A unique slug for the good, used for URL representation. The slug is validated upon setting to ensure it meets URL-friendly criteria.
     */
    @Column(name = "slug", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String slug;

    /**
     * A set of {@link Cost_Building_Goods} entities that reference this good as a construction requirement for buildings.
     * This relationship is managed as a one-to-many association, indicating the various buildings that require this good.
     */
    @OneToMany(mappedBy = "good")
    @JsonBackReference
    @ToString.Exclude
    private Set<Cost_Building_Goods> neededForBuildings;

    /**
     * Retrieves the slug associated with this good.
     *
     * @return The slug as a {@link String}.
     */
    @Override
    public String getSlug() {
        return this.slug;
    }

    /**
     * Sets and validates the slug for this good. If the slug is invalid, an exception is thrown.
     *
     * @param slug The slug to set for this good.
     * @throws IllegalStateException if the slug is invalid as determined by {@link SlugUtil}.
     */
    public void setSlug(String slug) {
        if (!SlugUtil.validateSlug(slug)) {
            throw new IllegalStateException("Could not create Slug for" + slug);
        }

        this.slug = slug;
    }
}