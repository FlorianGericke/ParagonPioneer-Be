package com.example.paragonPioneerBackend.Bin.Config;

import com.example.paragonPioneerBackend.Bin.Filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This is the SecurityConfiguration class.
 * It configures the security settings for the application.
 * It is annotated with @Configuration, meaning it's a configuration class in the Spring framework.
 * It's also annotated with @EnableWebSecurity, which enables Spring Security's web security support.
 * It's also annotated with @RequiredArgsConstructor, which generates a constructor with required fields.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    // The JwtAuthenticationFilter and AuthenticationProvider are automatically injected into this configuration using the @RequiredArgsConstructor annotation from Lombok
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    /**
     * This method configures the SecurityFilterChain.
     * It disables CSRF protection, configures the request matchers, sets the session creation policy, sets the authentication provider, and adds the JwtAuthenticationFilter.
     * It returns the configured SecurityFilterChain.
     * @param httpSecurity the HttpSecurity object
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // Disable CSRF protection
                .csrf(AbstractHttpConfigurer::disable)
                // Configure the request matchers
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(
                                        AntPathRequestMatcher.antMatcher("/api/v1/auth/authenticate"),
                                        AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/api/v1/**"),
                                        AntPathRequestMatcher.antMatcher("/swagger-ui/**"),
                                        AntPathRequestMatcher.antMatcher("/swagger-ui.html"),
                                        AntPathRequestMatcher.antMatcher("/v3/**")
                                ).permitAll()
                                .anyRequest().authenticated()
                )
                // Set the session creation policy
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Set the authentication provider
                .authenticationProvider(authenticationProvider)
                // Add the JwtAuthenticationFilter
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}