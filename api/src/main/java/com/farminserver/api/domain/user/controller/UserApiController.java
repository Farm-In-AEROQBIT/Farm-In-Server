package com.farminserver.api.domain.user.controller;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.api.domain.user.controller.model.UserResponse;
import com.farminserver.api.domain.user.converter.UserConverter;
import com.farminserver.db.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    private UserConverter userConverter;

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
        UserEntity savedUser = userBusiness.save(userEntity);
        return userConverter.toResponse(savedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable String id) {
        userBusiness.deleteById(id);
    }
}
