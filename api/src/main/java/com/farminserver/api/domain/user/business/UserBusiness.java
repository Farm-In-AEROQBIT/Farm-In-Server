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
        // FarmInfoEntity 생성 또는 기존 entity 설정
        FarmInfoEntity farmInfo = user.getFarmInfo();
        if (farmInfo == null) {
            farmInfo = new FarmInfoEntity();
        }
        farmInfo.setFarmName(user.getFarmInfo().getFarmName());

        farmInfoBusiness.save(farmInfo);

        user.setFarmInfo(farmInfo);  // 사용자와 FarmInfo 연결

        return userRepository.save(user);
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
