package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

/**
 * DTO for sending Population data
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class PopulationDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

}
