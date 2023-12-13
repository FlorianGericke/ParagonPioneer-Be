package com.example.ppapi.Entity;

import com.example.ppapi.Entity.JoinTables.Cost_Building_Population;
import com.example.ppapi.Entity.JoinTables.Population_Requirement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE population SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Population extends BaseEntity {

    @Column(name="name", nullable = true, columnDefinition = "TEXT")
    private String name;

    @OneToMany(mappedBy = "population")
    @JsonManagedReference
    @ToString.Exclude
    Set<Population_Requirement> requiredGoods;

    @OneToMany(mappedBy = "population")
    @JsonBackReference
    @ToString.Exclude
    Set<Cost_Building_Population> requiredBuilding;
}
