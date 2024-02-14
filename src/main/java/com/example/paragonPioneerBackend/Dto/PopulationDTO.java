package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("slug")
    @Builder.Default
    private String slug = "";
}
