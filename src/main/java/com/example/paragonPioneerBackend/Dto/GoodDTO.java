package com.example.paragonPioneerBackend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Data Transfer Object (DTO) for conveying good-related information between the application layers,
 * particularly useful for transferring good data to and from the user interface or API endpoints.
 * This class encapsulates the basic attributes of a good, such as its identifier, name, remarks, and slug,
 * making it suitable for CRUD operations and listings in the context of a user interface or an API.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GoodDTO {
    /**
     * The unique identifier of the good. This ID is used to uniquely identify a good within the system,
     * facilitating easy referencing and data manipulation.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The name of the good. Provides a human-readable name for the good, which can be used for display
     * purposes in the user interface or for identification in APIs.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Additional remarks or notes about the good. This can include any extra information that might be
     * relevant for users or the system when dealing with the good.
     */
    @JsonProperty("remarks")
    private String remarks;

    /**
     * A slug for the good, providing a URL-friendly string identifier. This is particularly useful for
     * creating more readable and SEO-friendly URLs in web applications.
     * By default, it is initialized as an empty string, indicating it can be optionally provided.
     */
    @JsonProperty("slug")
    @Builder.Default
    private String slug = "";

    /**
     * A boolean flag indicating whether the good is a map resource. Map resources are goods that are not
     * producible and are the beginning product of a process chain. By default, this flag is set to false,
     * indicating that the good is not a map resource.
     */
    @JsonProperty("slug")
    @Builder.Default
    private boolean isMapResource = false;
}