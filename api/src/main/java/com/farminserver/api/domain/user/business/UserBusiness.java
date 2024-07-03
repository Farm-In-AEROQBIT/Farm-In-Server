package com.farminserver.api.domain.user.business;

import com.farminserver.api.common.annotation.Business;
import com.farminserver.db.user.UserEntity;
import com.farminserver.db.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Business
@Component
@RequiredArgsConstructor
public class UserBusiness {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}