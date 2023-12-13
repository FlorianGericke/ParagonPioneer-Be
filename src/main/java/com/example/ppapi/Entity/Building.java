package com.example.ppapi.Entity;

import com.example.ppapi.Entity.JoinTables.Cost_Building_Goods;
import com.example.ppapi.Entity.JoinTables.Cost_Building_Population;
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
@SQLDelete(sql = "UPDATE building SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Building extends BaseEntity {

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String remarks;

    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    Set<Cost_Building_Goods> costs;

    @OneToOne(mappedBy = "building")
    @JsonManagedReference
    @ToString.Exclude
    Cost_Building_Population population;
}
