package com.farminserver.api.util.Jwt;

import com.farminserver.api.common.error.TokenErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("your_secret_key_your_secret_key_your_secret_key".getBytes());

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10시간 유효
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public Optional<TokenErrorCode> validateToken(String token) {
        try {
            extractClaims(token);
            return Optional.empty();
        } catch (ExpiredJwtException e) {
            return Optional.of(TokenErrorCode.EXPIRED_TOKEN);
        } catch (JwtException e) {
            return Optional.of(TokenErrorCode.INVALID_TOKEN);
        } catch (Exception e) {
            return Optional.of(TokenErrorCode.TOKEN_EXCEPTION);
        }
    }
}
