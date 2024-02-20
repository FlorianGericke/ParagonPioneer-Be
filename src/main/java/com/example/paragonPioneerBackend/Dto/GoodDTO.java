package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("slug")
    @Builder.Default
    private String slug = "";
}
