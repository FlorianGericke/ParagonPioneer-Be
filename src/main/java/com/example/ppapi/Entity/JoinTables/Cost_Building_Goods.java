package com.example.ppapi.Entity.JoinTables;

import com.example.ppapi.Entity.BaseEntity;
import com.example.ppapi.Entity.Building;
import com.example.ppapi.Entity.Good;
import com.example.ppapi.Entity.Population;
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
@SQLDelete(sql = "UPDATE cost_building_goods SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")

public class Cost_Building_Goods extends BaseEntity {
    @ManyToOne()
    @JoinColumn(name = "good_id")
    @JsonManagedReference
    Good good;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "building_id")
    Building building;

    @Column()
    private int amount;
}
