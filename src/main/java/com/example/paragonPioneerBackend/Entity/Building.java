package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.JoinTables.Cost_Building_Goods;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@SQLDelete(sql = "UPDATE building SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor
public abstract class Building extends BaseEntity{
    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String remarks;

    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    Set<Cost_Building_Goods> costs;
}
