package com.farminserver.api.util.Jwt;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtRefreshFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public JwtRefreshFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String refreshToken = request.getHeader("Refresh-Token");
        if (refreshToken != null && jwtUtil.validateToken(refreshToken).isEmpty()) {
            Claims claims = jwtUtil.extractClaims(refreshToken);
            String username = claims.getSubject();
            String role = claims.get("role", String.class);
            String newAccessToken = jwtUtil.generateAccessToken(username, role);
            response.setHeader("Access-Token", newAccessToken);
        }
        filterChain.doFilter(request, response);
    }
}
