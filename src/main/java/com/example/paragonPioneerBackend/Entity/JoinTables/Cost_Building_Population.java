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

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE cost_building_population SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Cost_Building_Population extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "population_id")
    @JsonManagedReference
    Population population;

    @OneToOne()
    @JsonBackReference
    @JoinColumn(name = "building_id")
    Building building;

    @Column()
    private int amount;
}
