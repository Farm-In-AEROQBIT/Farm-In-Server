package com.farminserver.api.domain.user.business;

import com.farminserver.db.user.UserEntity;
import com.farminserver.db.user.UserRepository;
import com.farminserver.db.farm_info.FarmInfoEntity;
import com.farminserver.api.domain.farm_info.business.FarmInfoBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserBusiness {

    private final UserRepository userRepository;

    @Lazy
    private final FarmInfoBusiness farmInfoBusiness;

    public UserEntity save(UserEntity user) {
        UserEntity savedUser = userRepository.save(user);

        // 새로운 FarmInfoEntity를 생성하고 저장
        FarmInfoEntity farmInfo = new FarmInfoEntity();
        farmInfo.setFarmName(user.getFarmName());
        farmInfoBusiness.save(farmInfo);

        return savedUser;
    }

    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserEntity> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    public UserEntity getByUserName(String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }

    public UserEntity getByUserId(String userId) {
        return userRepository.findByUserId(userId).orElse(null);
    }
}
