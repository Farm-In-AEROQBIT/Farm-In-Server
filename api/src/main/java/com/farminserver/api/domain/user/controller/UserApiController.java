package com.farminserver.api.domain.user.controller;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.api.domain.user.controller.model.UserResponse;
import com.farminserver.api.domain.user.converter.UserConverter;
import com.farminserver.api.util.Jwt.JwtUtil;
import com.farminserver.db.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.farminserver.api.util.PassWord.PasswordValidator;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private JwtUtil jwtUtil;

    private boolean validateToken(String token) {
        return jwtUtil.validateToken(token).isEmpty();
    }

    @GetMapping("/info")
    public UserResponse getUserInfo(@RequestHeader("Authorization") String token) {
        if (!validateToken(token)) {
            throw new RuntimeException("Invalid token");
        }
        String userId = jwtUtil.extractUsername(token); // JWT에서 userId 추출
        UserEntity userEntity = userBusiness.getById(userId);
        return userConverter.toResponse(userEntity);
    }

    @GetMapping("/farm")
    public String getUserFarmInfo(@RequestHeader("Authorization") String token) {
        if (!validateToken(token)) {
            throw new RuntimeException("Invalid token");
        }
        String userId = jwtUtil.extractUsername(token); // JWT에서 userId 추출
        UserEntity userEntity = userBusiness.getById(userId);
        return userEntity.getFarm_name();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        UserEntity userEntity = userBusiness.getById(id);
        return userConverter.toResponse(userEntity);
    }

    @GetMapping("/all")
    public List<UserResponse> getAllUsers() {
        List<UserEntity> userEntities = userBusiness.getAll();
        return userEntities.stream()
                .map(userConverter::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public UserResponse saveUser(@RequestBody UserEntity userEntity) {
        if (!PasswordValidator.containsSpecialCharacter(userEntity.getUserPw())) {
            throw new IllegalArgumentException("Password must contain a special character.");
        }
        UserEntity savedUser = userBusiness.save(userEntity);
        return userConverter.toResponse(savedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable String id) {
        userBusiness.deleteById(id);
    }
}
