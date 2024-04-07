package com.example.paragonPioneerBackend.Util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * The EnvironmentUtil class is a Spring component that holds the base URL for the API.
 * It uses the @Value annotation to inject the value of the API_BASE_URL property from the application's configuration.
 * The base URL is stored in a static field so that it can be accessed from anywhere in the application.
 */
@Getter
@Component
public class EnvironmentUtil {
    /**
     * The base URL for the API. This is a static field so it can be accessed from anywhere in the application.
     */
    @Getter
    private static String apiBaseUrl;

    /**
     * The constructor for the EnvironmentUtil class.
     * It uses the @Autowired annotation to indicate that it should be automatically called by Spring to create an instance of the EnvironmentUtil class.
     * The @Value("${API_BASE_URL}") annotation is used to inject the value of the API_BASE_URL property from the application's configuration into the apiBaseUrl parameter.
     * The value of the apiBaseUrl parameter is then assigned to the apiBaseUrl field.
     *
     * @param apiBaseUrl The base URL for the API, injected from the application's configuration.
     */
    @Autowired
    public EnvironmentUtil(@Value("${API_BASE_URL}") String apiBaseUrl) {
        EnvironmentUtil.apiBaseUrl = apiBaseUrl;
    }
}
