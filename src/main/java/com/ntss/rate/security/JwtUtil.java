package com.ntss.rate.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

	 @SuppressWarnings("deprecation")
	byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512).getEncoded();
     String base64Key = Base64.getEncoder().encodeToString(keyBytes);
    // Secret Key (Use environment variables for production)
    private static final String SECRET_KEY = "YourSecureKeyMustBeAtLeast256BitsLongForHS512";

    // Secure Key Initialization
    private final SecretKey key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(keyBytes));

    // Generate Token
    public String generateToken(String username) {
        return Jwts.builder()
                .claims()  // Use claims() instead of setSubject()
                .subject(username) // Set subject using the new method
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .and()
                .signWith(key, SignatureAlgorithm.HS512) // Sign using HS512
                .compact();
    }

    // Validate Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            System.out.println("Invalid token: " + e.getMessage());
            return false;
        }
    }

    // Extract Username
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject(); // No change required for extracting subject
    }
    
    public String generateTokenWithClaims(String username, String role) {
        return Jwts.builder()
                .claims()
                .subject(username) // Subject claim
                .add("role", role) // Custom claim
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .and()
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

}
