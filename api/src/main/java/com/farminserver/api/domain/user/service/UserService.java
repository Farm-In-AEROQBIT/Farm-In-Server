package com.farminserver.api.domain.user.service;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.db.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserBusiness userBusiness;

    public UserEntity save(UserEntity userEntity) {
        return userBusiness.save(userEntity);
    }

    public UserEntity getById(Long id) {
        return userBusiness.getById(id);
    }

    public List<UserEntity> findAll() {
        return userBusiness.getAll();
    }

    public void deleteById(Long id) {
        userBusiness.deleteById(id);
    }

    public List<UserEntity> findByRole(String role) {
        return userBusiness.findByRole(role);
    }

    public UserEntity getByUserName(String userName) {
        return userBusiness.getByUserName(userName);
    }

    public UserEntity getByUserId(String userId) {
        return userBusiness.getByUserId(userId);
    }
}
