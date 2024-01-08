package com.example.paragonPioneerBackend.Entity.JoinTables;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Entity.Population;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE population_requirement SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Population_Requirement extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "good_id")
    @JsonManagedReference
    Good good;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "population_id")
    Population population;

    @Column()
    private float consumption;

    @Column()
    private float produce;

    @Column()
    private boolean isBasic;
}
