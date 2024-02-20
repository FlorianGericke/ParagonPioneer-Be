package com.example.paragonPioneerBackend.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

//todo resolve all deprecated methods

@Service(value = "jwt_service")
public class JwtService {

    // TODO This Api key is just for development and testing, not for production !!!!
    private static final String API_SECRET_KEY = "xdQE-zErxnZCGrhUcGi1WpPTFiI5UfmDBqGhZ-nG55A";

    SecretKeySpec secretKeySpec = new SecretKeySpec(API_SECRET_KEY.getBytes(), "HS256");

    public String extractUserName(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims jwtClaim = extractAllClaims(token);
        return claimsResolver.apply(jwtClaim);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
        Map<String, Objects> extraClaims,
        UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 24)) // 24h and 1000 ms
                .signWith(secretKeySpec)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts
                .parser()
                .verifyWith(secretKeySpec)
                .build()
                .parseClaimsJws(jwtToken)
                .getPayload();
    }
}
