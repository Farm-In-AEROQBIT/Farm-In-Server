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
        farmInfo.setFarm_name(user.getFarmName());
        farmInfoBusiness.save(farmInfo);

        return savedUser;
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
