package com.farminserver.api.util.Jwt;

import com.farminserver.api.common.error.TokenErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    private final SecretKey secretKey;
    private final long accessTokenValidity;
    private final long refreshTokenValidity;

    public JwtUtil(@Value("${JWT.SECRET}") String secret,
                   @Value("${JWT.ACCESSTOKENVALIDITY}") long accessTokenValidity,
                   @Value("${JWT.REFRESHTOKENVALIDITY}") long refreshTokenValidity) {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String generateAccessToken(String username, String role) {
        String token = Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenValidity))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        log.debug("Generated Access Token: {}", token);
        return token;
    }

    public String generateRefreshToken(String username) {
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenValidity))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        log.debug("Generated Refresh Token: {}", token);
        return token;
    }

    public Claims extractClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            log.error("Failed to extract claims from token: {}", token, e);
            throw e;  // Ensure the exception is propagated to caller
        }
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
            log.error("Token expired: {}", token, e);
            return Optional.of(TokenErrorCode.EXPIRED_TOKEN);
        } catch (JwtException e) {
            log.error("Invalid token: {}", token, e);
            return Optional.of(TokenErrorCode.INVALID_TOKEN);
        } catch (Exception e) {
            log.error("Token validation exception: {}", token, e);
            return Optional.of(TokenErrorCode.TOKEN_EXCEPTION);
        }
    }
}
