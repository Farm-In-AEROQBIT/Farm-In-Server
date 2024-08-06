package com.farminserver.api.domain.user.service;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.api.util.PassWord.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farminserver.db.user.UserEntity;

import java.util.List;

@Service
public class UserService {

    private final UserBusiness userBusiness;

    @Autowired
    public UserService(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    public UserEntity save(UserEntity user) {
        if (!PasswordValidator.containsSpecialCharacter(user.getUserPw())) {
            throw new IllegalArgumentException("Password must contain a special character.");
        }
        return userBusiness.save(user);
    }

    public UserEntity getById(String id) {
        return userBusiness.getById(id);
    }

    public List<UserEntity> getAll() {
        return userBusiness.getAll();
    }

    public void deleteById(String id) {
        userBusiness.deleteById(id);
    }
}
