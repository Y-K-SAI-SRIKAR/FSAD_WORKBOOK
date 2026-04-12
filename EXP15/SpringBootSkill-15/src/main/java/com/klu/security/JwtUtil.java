package com.klu.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private String secret = "klu_secret_key_klu_secret_key_12345";

    // 🔹 Generate Token
    public String generateToken(String username) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }

    // 🔹 Extract Username
    public String extractUsername(String token) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 🔹 Validate Token
    public boolean validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(secret.getBytes());

            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}