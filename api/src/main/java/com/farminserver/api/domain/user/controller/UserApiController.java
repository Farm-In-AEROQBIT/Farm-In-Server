package com.farminserver.api.domain.user.controller;

import com.farminserver.api.domain.user.service.UserService;
import com.farminserver.db.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/role/{role}")
    public List<UserEntity> getUsersByRole(@PathVariable String role) {
        return userService.findByRole(role);
    }

    @GetMapping("/username/{userName}")
    public UserEntity getUserByUserName(@PathVariable String userName) {
        return userService.getByUserName(userName);
    }

    @GetMapping("/userid/{userId}")
    public UserEntity getUserByUserId(@PathVariable String userId) {
        return userService.getByUserId(userId);
    }
}
