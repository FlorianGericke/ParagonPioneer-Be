package com.example.paragonPioneerBackend.Bin.Filter;

import com.example.paragonPioneerBackend.Bin.Security.AuthServices.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * This is the JwtAuthenticationFilter class.
 * It extends the OncePerRequestFilter class from Spring Security, meaning it's a filter that is executed once per request.
 * It is annotated with @Component, meaning it's a component in the Spring framework.
 * It's also annotated with @RequiredArgsConstructor, which generates a constructor with required fields.
 */
@Component(value = "jwt_authentication_filter")
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // The JwtService and UserDetailsService are automatically injected into this filter using the @RequiredArgsConstructor annotation from Lombok
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    /**
     * This method is the main filter method.
     * It checks the Authorization header of the request for a JWT token.
     * If a token is found, it extracts the username from the token, loads the user details, and sets the authentication in the SecurityContext.
     * It then calls the next filter in the chain.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @param filterChain the FilterChain object
     * @throws ServletException if an error occurs during filtering
     * @throws IOException if an error occurs during filtering
     */
    @SneakyThrows
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // token always start at index 7
        jwtToken = authHeader.substring(7);
        userEmail = jwtService.extractUserName(jwtToken);

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            if (jwtService.isTokenValid(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}