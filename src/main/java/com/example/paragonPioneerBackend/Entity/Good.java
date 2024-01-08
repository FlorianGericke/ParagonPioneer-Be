package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE good SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Good extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String remarks;

    @OneToMany(mappedBy = "good")
    @JsonBackReference
    @ToString.Exclude
    private Set<Cost_Building_Goods> neededForBuildings;
}
