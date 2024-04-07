package com.example.paragonPioneerBackend.Dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for conveying good-related information between the application layers,
 * particularly useful for transferring good data to and from the user interface or API endpoints.
 * This class encapsulates the basic attributes of a good, such as its identifier, name, remarks, and slug,
 * making it suitable for CRUD operations and listings in the context of a user interface or an API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodInput {
    /**
     * The name of the good. Provides a human-readable name for the good, which can be used for display
     * purposes in the user interface or for identification in APIs.
     */
    @Builder.Default
    @JsonProperty("name")
    private String name = null;

    /**
     * Additional remarks or notes about the good. This can include any extra information that might be
     * relevant for users or the system when dealing with the good.
     */
    @Builder.Default
    @JsonProperty("remarks")
    private String remarks = null;

    /**
     * A boolean flag indicating whether the good is a map resource. Map resources are goods that are not
     * producible and are the beginning product of a process chain. By default, this flag is set to false,
     * indicating that the good is not a map resource.
     */
    @Builder.Default
    @JsonProperty("isMapResource")
    private boolean isMapResource = false;
}