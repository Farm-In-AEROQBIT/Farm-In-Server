package com.farminserver.api.util.Jwt;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.farminserver.api.common.error.TokenErrorCode;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JwtRefreshFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtRefreshFilter.class);
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public JwtRefreshFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug("Entering JwtRefreshFilter: {}", request.getRequestURI());

        if (request.getRequestURI().startsWith("/api/user/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String refreshToken = request.getHeader("Refresh-Token");

        if (refreshToken != null) {
            log.debug("Refresh-Token found: {}", refreshToken);

            Optional<TokenErrorCode> tokenValidation = jwtUtil.validateToken(refreshToken);

            if (tokenValidation.isEmpty()) {
                Claims claims = jwtUtil.extractClaims(refreshToken);
                String username = claims.getSubject();
                String role = claims.get("role", String.class);

                log.debug("Generating new access token for user: {}", username);
                String newAccessToken = jwtUtil.generateAccessToken(username, role);

                Map<String, String> tokenResponse = new HashMap<>();
                tokenResponse.put("accessToken", newAccessToken);

                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getWriter(), tokenResponse);
                log.debug("New access token generated and sent to client.");
                return;
            } else {
                log.debug("Invalid Refresh-Token: {}", tokenValidation.get());
            }
        }

        filterChain.doFilter(request, response);
        log.debug("Exiting JwtRefreshFilter: {}", request.getRequestURI());
    }


}
