package com.farminserver.api.controller;

import com.farminserver.api.util.Jwt.JwtUtil;
import com.farminserver.api.model.LoginRequest;
import com.farminserver.api.model.JwtResponse;
import com.farminserver.api.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationService.authenticate(
                    loginRequest.getUsername(), loginRequest.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtil.generateAccessToken(loginRequest.getUsername(), "ROLE_USER");
            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Unauthorized: " + e.getMessage());
        }
    }
}
