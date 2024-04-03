package com.example.paragonPioneerBackend.Bin.Security.AuthServices;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * This is the JwtService class.
 * It handles the generation, validation, and extraction of JWT tokens.
 * It is annotated with @Service, meaning it's a service component in the Spring framework.
 */
@Service(value = "jwt_service")
public class JwtService {

    // TODO: This API key is just for development and testing, not for production !!!!!
    private static final String API_SECRET_KEY = "MHcCAQEEIOz5LI8807OyfRfM5XjqfA9hq/9aeABbPYIBe31sl3eZoAoGCCqGSM49AwEHoUQDQgAE09I+JA9i4G0K0AuqT9MuGimZ7Od/n273rEIf/l2HqUCgUPXQvd2Uu45q+ikOBGJsbw9rNDBeOKdnSsm7nazeFg==";
    private final SecretKey secretKey = new SecretKeySpec(API_SECRET_KEY.getBytes(),"HmacSHA256");

    /**
     * This method extracts the username from the JWT token.
     * @param jwtToken the JWT token
     * @return the username
     * @throws Exception if an error occurs during extraction
     */
    public String extractUserName(String jwtToken) throws Exception {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    /**
     * This method extracts a claim from the JWT token.
     * @param token the JWT token
     * @param claimsResolver the function to resolve the claim
     * @return the claim
     * @throws Exception if an error occurs during extraction
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws Exception {
        final Claims jwtClaim = extractAllClaims(token);
        return claimsResolver.apply(jwtClaim);
    }

    /**
     * This method generates a JWT token for a user.
     * @param userDetails the user details
     * @return the JWT token
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * This method generates a JWT token for a user with extra claims.
     * @param extraClaims the extra claims
     * @param userDetails the user details
     * @return the JWT token
     */
    public String generateToken(
            Map<String, Objects> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .signWith(secretKey)
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 24h and 1000 ms
                .compact();
    }

    /**
     * This method checks if a JWT token is valid for a user.
     * @param token the JWT token
     * @param userDetails the user details
     * @return true if the token is valid, false otherwise
     * @throws Exception if an error occurs during validation
     */
    public boolean isTokenValid(String token, UserDetails userDetails) throws Exception {
        final String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * This method checks if a JWT token is expired.
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     * @throws Exception if an error occurs during validation
     */
    private boolean isTokenExpired(String token) throws Exception {
        return extractExpiration(token).before(new Date());
    }

    /**
     * This method extracts the expiration date from the JWT token.
     * @param token the JWT token
     * @return the expiration date
     * @throws Exception if an error occurs during extraction
     */
    private Date extractExpiration(String token) throws Exception {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * This method extracts all claims from the JWT token.
     * @param jwtToken the JWT token
     * @return the claims
     * @throws Exception if an error occurs during extraction
     */
    private Claims extractAllClaims(String jwtToken) throws Exception {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(jwtToken).getPayload();
    }
}