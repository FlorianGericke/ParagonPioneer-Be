package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

/**
 * DTO for sending Good data
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GoodDTO{
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("remarks")
    private String remarks;
}
