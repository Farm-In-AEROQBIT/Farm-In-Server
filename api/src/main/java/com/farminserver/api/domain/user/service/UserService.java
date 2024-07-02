package com.farminserver.api.domain.user.service;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.api.domain.user.controller.model.UserResponse;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farminserver.db.user.UserRepository;
import com.farminserver.db.user.UserEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserBusiness userbusiness;

    public UserEntity save(UserEntity user) {
        return userbusiness.save(user);
    }

    public UserEntity getById(String id) {
        return userbusiness.getById(id);
    }

    public List<UserEntity> getAll() {
        return userbusiness.getAll();
    }

    public void deleteById(String id) {
        userbusiness.deleteById(id);
    }
}