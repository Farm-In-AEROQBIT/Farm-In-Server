package com.farminserver.api.domain.admin.controller;

import com.farminserver.api.common.error.UserError;
import com.farminserver.api.domain.admin.controller.model.AdminResponse;
import com.farminserver.api.domain.admin.converter.AdminConverter;
import com.farminserver.api.domain.admin.service.AdminService;
import com.farminserver.api.domain.user.controller.model.UserResponse;
import com.farminserver.api.domain.user.converter.UserConverter;
import com.farminserver.api.util.Jwt.JwtUtil;
import com.farminserver.db.admin.AdminEntity;
import com.farminserver.db.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farminserver.api.common.error.TokenErrorCode;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminConverter adminConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/create")
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody AdminEntity adminEntity) {
        AdminEntity savedAdmin = adminService.save(adminEntity);
        AdminResponse response = adminConverter.convertToResponse(savedAdmin);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminEntity adminEntity) {
        boolean isAuthenticated = adminService.authenticateAdmin(adminEntity);
        if (isAuthenticated) {
            String token = jwtUtil.generateToken(adminEntity.getAdminId(), "ADMIN");
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Login failed");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String token) {
        if (!adminService.isAuthorized(token, "ADMIN")) {
            return ResponseEntity.status(UserError.AUTHORIZATION_ACCESS_NOT_FOUNT.getHttpStatusCode())
                    .body(UserError.AUTHORIZATION_ACCESS_NOT_FOUNT.getDescription());
        }
        List<UserEntity> users = adminService.getAllUsers();
        List<UserResponse> userResponses = users.stream()
                .map(userConverter::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@RequestHeader("Authorization") String token, @PathVariable String id) {
        Optional<TokenErrorCode> tokenError = jwtUtil.validateToken(token);
        if (tokenError.isPresent()) {
            TokenErrorCode errorCode = tokenError.get();
            return ResponseEntity.status(errorCode.getHttpStatusCode())
                    .body(new UserResponse(errorCode.getDescription()));
        }

        if (!adminService.isAuthorized(token, "USER")) {
            return ResponseEntity.status(UserError.AUTHORIZATION_ACCESS_NOT_FOUNT.getHttpStatusCode())
                    .body(new UserResponse(UserError.AUTHORIZATION_ACCESS_NOT_FOUNT.getDescription()));
        }

        String usernameFromToken = jwtUtil.extractUsername(token);
        if (!usernameFromToken.equals(id) && !jwtUtil.extractRole(token).equals("ADMIN")) {
            return ResponseEntity.status(UserError.AUTHORIZATION_ACCESS_NOT_FOUNT.getHttpStatusCode())
                    .body(new UserResponse(UserError.AUTHORIZATION_ACCESS_NOT_FOUNT.getDescription()));
        }

        Optional<UserEntity> user = adminService.getUserById(id);
        return user.map(userEntity -> ResponseEntity.ok(userConverter.toResponse(userEntity)))
                .orElseGet(() -> ResponseEntity.status(404).body(new UserResponse("User not found")));
    }
}
