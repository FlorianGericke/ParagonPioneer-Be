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
 * Entity representing a Good
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

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "remarks", nullable = true, columnDefinition = "varchar(255)")
    private String remarks;

    @Column(name = "slug", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String slug;

    @OneToMany(mappedBy = "good")
    @JsonBackReference
    @ToString.Exclude
    private Set<Cost_Building_Goods> neededForBuildings;

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
