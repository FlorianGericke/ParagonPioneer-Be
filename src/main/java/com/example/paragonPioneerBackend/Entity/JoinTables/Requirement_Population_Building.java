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
 * Entity for join table Required_Populations_Building
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE requirement_population_building SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Requirement_Population_Building extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "population_id")
    @JsonManagedReference
    private Population population;

    @OneToOne()
    @JsonBackReference
    @JoinColumn(name = "building_id")
    private Building building;

    @Column()
    private int amount;
}
