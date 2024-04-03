package com.example.paragonPioneerBackend.Bin.Security;

import com.example.paragonPioneerBackend.Bin.Security.AuthServices.AuthenticationService;
import com.example.paragonPioneerBackend.Bin.Security.Requests.AuthenticationRequest;
import com.example.paragonPioneerBackend.Bin.Security.Requests.RegisterRequest;
import com.example.paragonPioneerBackend.Bin.Security.Responses.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the AuthenticationController class.
 * It handles HTTP requests related to user authentication.
 * It is annotated with @RestController, meaning it's a controller where
 * every method returns a domain object instead of a view.
 * It's also annotated with @RequestMapping("/api/v1/auth"), meaning all its endpoints are prefixed with "/api/v1/auth".
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    // The AuthenticationService is automatically injected into this controller using the @RequiredArgsConstructor annotation from Lombok
    private final AuthenticationService authenticationService;

    /**
     * This method handles the POST request for user registration.
     * It takes a RegisterRequest object as a parameter, which should include the necessary information for user registration.
     * It returns a ResponseEntity with an AuthenticationResponse object.
     * @param request the RegisterRequest object
     * @return ResponseEntity with the AuthenticationResponse object
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @ParameterObject RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    /**
     * This method handles the POST request for user authentication.
     * It takes an AuthenticationRequest object as a parameter, which should include the necessary information for user authentication.
     * It returns a ResponseEntity with an AuthenticationResponse object.
     * @param request the AuthenticationRequest object
     * @return ResponseEntity with the AuthenticationResponse object
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @ParameterObject AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}