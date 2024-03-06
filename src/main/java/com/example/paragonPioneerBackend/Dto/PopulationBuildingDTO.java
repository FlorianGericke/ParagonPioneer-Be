package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Data Transfer Object (DTO) for conveying population building information between application layers,
 * particularly useful for operations involving the creation, update, or retrieval of population building data
 * through user interfaces or APIs. This DTO extends {@link BuildingDTO} with additional attributes specific
 * to buildings that accommodate population, such as their capacity.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@SuperBuilder
public class PopulationBuildingDTO extends BuildingDTO {

    /**
     * The capacity of the population building, indicating the maximum number of individuals
     * or units that the building can accommodate.
     */
    @JsonProperty("capacity")
    private int capacity;

    /**
     * Constructs a new instance of PopulationBuildingDTO with specified details including ID, name,
     * remarks, capacity, and slug. This constructor allows for the detailed initialization of a
     * population building data transfer object.
     *
     * @param id The unique identifier of the building.
     * @param name The name of the building.
     * @param remarks Additional remarks or notes about the building.
     * @param capacity The capacity of the population building.
     * @param slug The slug for URL-friendly identification of the building.
     */
    public PopulationBuildingDTO(String id, String name, String remarks, int capacity, String slug) {
        super(id, name, remarks, slug); // Call to the super class constructor to set common properties.
        this.capacity = capacity; // Set the specific property for the population building.
    }

    /**
     * Constructs a new instance of PopulationBuildingDTO with a specified capacity. This constructor
     * can be used when only the capacity of the population building needs to be specified, without
     * other details.
     *
     * @param capacity The capacity of the population building.
     */
    public PopulationBuildingDTO(int capacity) {
        super(); // Call to the default super class constructor.
        this.capacity = capacity; // Set the specific property for the population building.
    }
}
