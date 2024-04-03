package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.joinTables.CostBuildingGoods;
import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Slugable;
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
 * Represents a good within the application.
 * Goods are essential entities used within the application, associated with buildings and their construction or usage.
 * This class extends {@link BaseEntity} and implements {@link Slugable} to ensure it has a unique identifier and supports URL-friendly identifiers.
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "good")
@SQLDelete(sql = "UPDATE good SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor
public class Good extends Slugable {

    /**
     * Optional remarks providing additional information about the good. It can be null and provides flexibility in describing the good.
     */
    @Column(name = "remarks", nullable = true, columnDefinition = "varchar(255)")
    private String remarks;


    /**
     * A boolean flag indicating whether the good is a map resource. Map resources are goods that are not producable and are the beginning product of a process chain.
     * By default, this flag is set to false, indicating that the good is not a map resource.
     *
     * @Column is a JPA annotation that specifies the mapped column for a persistent property or field.
     * name: The name of the column in the database table.
     * nullable: Whether the database column can have null values. In this case, it cannot.
     * columnDefinition: The SQL fragment that is used when generating the DDL for the column. In this case, it's a boolean.
     * @Builder.Default is a Lombok annotation that sets the default value for this field when building an instance of Good using the builder pattern.
     */
    @Column(name = "isMapResource", nullable = false, columnDefinition = "boolean")
    private boolean isMapResource;

    /**
     * A set of {@link CostBuildingGoods} entities that reference this good as a construction requirement for buildings.
     * This relationship is managed as a one-to-many association, indicating the various buildings that require this good.
     */
    @OneToMany(mappedBy = "good")
    @JsonBackReference
    @ToString.Exclude
    private Set<CostBuildingGoods> neededForBuildings;

    /**
     * Constructor for the Good class.
     *
     * @param name The name of the good.
     * @param slug The slug for URL representation of the good.
     * @param remarks Optional remarks providing additional information about the good.
     * @param isMapResource A boolean flag indicating whether the good is a map resource.
     * @param neededForBuildings A set of {@link CostBuildingGoods} entities that reference this good as a construction requirement for buildings.
     */
    @Builder
    public Good(String name, String slug, String remarks, boolean isMapResource, Set<CostBuildingGoods> neededForBuildings) {
        super(name, slug);
        this.remarks = remarks;
        this.isMapResource = isMapResource;
        this.neededForBuildings = neededForBuildings;
    }
}