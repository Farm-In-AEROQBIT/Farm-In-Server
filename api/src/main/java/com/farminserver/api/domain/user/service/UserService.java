package com.farminserver.api.domain.user.service;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.api.domain.user.controller.model.UserRegistrationRequest;
import com.farminserver.db.farm_info.FarmInfoEntity;
import com.farminserver.api.domain.farm_info.business.FarmInfoBusiness;
import com.farminserver.db.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserBusiness userBusiness;
    private final BCryptPasswordEncoder passwordEncoder;
    private final FarmInfoBusiness farmInfoBusiness;

    @Autowired
    public UserService(UserBusiness userBusiness, BCryptPasswordEncoder passwordEncoder, FarmInfoBusiness farmInfoBusiness) {
        this.userBusiness = userBusiness;
        this.passwordEncoder = passwordEncoder;
        this.farmInfoBusiness = farmInfoBusiness;
    }

    public UserEntity registerUser(UserRegistrationRequest request) {
        if (userBusiness.getByUserId(request.getUserId()) != null) {
            throw new RuntimeException("User ID already exists");
        }
        if (userBusiness.getByUserName(request.getUserName()) != null) {
            throw new RuntimeException("Username already exists");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(request.getUserId());
        userEntity.setUserPw(passwordEncoder.encode(request.getUserPw())); // 비밀번호 해싱
        userEntity.setUserName(request.getUserName());
        userEntity.setUserPhoneNum(request.getUserPhoneNum());

        // Optional: FarmInfo 설정
        if (request.getFarmName() != null) {
            FarmInfoEntity farmInfo = farmInfoBusiness.getById(request.getFarmName());
            userEntity.setFarmInfo(farmInfo);
        }

        return userBusiness.save(userEntity);
    }

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
