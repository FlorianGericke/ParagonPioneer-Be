package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * DTO for sending Building data
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BuildingDTO{
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("remarks")
    private String remarks;

}
