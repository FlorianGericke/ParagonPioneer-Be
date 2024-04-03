package com.example.paragonPioneerBackend.Bin.Security.AuthServices;

import com.example.paragonPioneerBackend.Bin.Security.Requests.AuthenticationRequest;
import com.example.paragonPioneerBackend.Bin.Security.Requests.RegisterRequest;
import com.example.paragonPioneerBackend.Bin.Security.Responses.AuthenticationResponse;
import com.example.paragonPioneerBackend.Entity.Admin;
import com.example.paragonPioneerBackend.Entity.entityEnums.Role;
import com.example.paragonPioneerBackend.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This is the AuthenticationService class.
 * It handles the registration and authentication of admins.
 * It is annotated with @Service, meaning it's a service component in the Spring framework.
 * It's also annotated with @RequiredArgsConstructor, which generates a constructor with required fields.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    // The AdminRepository, PasswordEncoder, JwtService, and AuthenticationManager are automatically injected into this service using the @RequiredArgsConstructor annotation from Lombok
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * This method handles the registration of a new admin.
     * It takes a RegisterRequest object as a parameter, which should include the necessary information for registration.
     * It returns an AuthenticationResponse object which includes the JWT token for the registered admin.
     * @param request the RegisterRequest object
     * @return the AuthenticationResponse object
     */
    public AuthenticationResponse register(RegisterRequest request) {
        var admin = Admin.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.Admin)
                .build();
        adminRepository.save(admin);

        var jwtToken = jwtService.generateToken(admin);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * This method handles the authentication of an admin.
     * It takes an AuthenticationRequest object as a parameter, which should include the necessary information for authentication.
     * It returns an AuthenticationResponse object which includes the JWT token for the authenticated admin.
     * @param request the AuthenticationRequest object
     * @return the AuthenticationResponse object
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var admin = adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("No Username found: " + request.getEmail()));

        var jwtToken = jwtService.generateToken(admin);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}