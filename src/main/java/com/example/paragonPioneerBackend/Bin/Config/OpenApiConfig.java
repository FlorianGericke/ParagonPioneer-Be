package com.example.paragonPioneerBackend.Bin.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

/**
 * This is the OpenApiConfig class.
 * It configures the OpenAPI documentation for the application.
 * It is annotated with @Configuration, meaning it's a configuration class in the Spring framework.
 * It's also annotated with @OpenAPIDefinition, which provides metadata for the API.
 * The @SecurityScheme annotation defines the security scheme for the API.
 */
@Configuration
@OpenAPIDefinition(
        // The @Info annotation provides information about the API
        info = @Info(
                title = "Paragon Pioneer Backend API",
                version = "v1",
                description = "API for the Paragon Pioneer Backend",
                contact = @Contact(
                        name = "Paragon Pioneer",
                        url = "https://github.com/LF12-ParagonPioneer"
                )),
        // The @Server annotation provides information about the server where the API is hosted
        servers = @Server(
                description = "Local development server",
                url = "http://localhost:8080/"
        ),
        // The @SecurityRequirement annotation specifies the security requirements for the API
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }
)
@SecurityScheme(
        // The @SecurityScheme annotation defines the security scheme for the API
        name = "bearerAuth",
        description = "JWT Bearer Token Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        scheme= "Bearer"
)
public class OpenApiConfig {
}