package com.example.paragonPioneerBackend.Entity.JoinTables;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.Good;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Represents a join table entity that links the {@link Building} and {@link Good} entities to define the cost of a building in terms of goods.
 * This entity captures the many-to-many relationship between buildings and goods, specifying the amount of each good required to construct or utilize a building.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "cost_building_goods")
@SQLDelete(sql = "UPDATE cost_building_goods SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Cost_Building_Goods extends BaseEntity {

    /**
     * The good that is part of the cost for a building. This is a many-to-one relationship as many costs can reference the same good.
     */
    @ManyToOne()
    @JoinColumn(name = "good_id")
    @JsonManagedReference
    private Good good;

    /**
     * The building that requires the specified good as part of its construction or operational cost.
     * This is a many-to-one relationship, indicating that many costs can be associated with the same building.
     */
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "building_id")
    private Building building;

    /**
     * The amount of the specified good required by the building. This quantity pertains to the cost relationship between the building and the good.
     */
    @Column()
    private int amount;
}
