package com.farminserver.api.domain.user.converter;

import com.farminserver.api.domain.user.controller.model.UserResponse;
import com.farminserver.db.user.UserEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.annotation.Converter;

@Converter
@Component
public class UserConverter {

    public UserResponse toResponse(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        String farmName = userEntity.getFarmInfo() != null ? userEntity.getFarmInfo().getFarmName() : null;

        return new UserResponse(
                userEntity.getUserId(),
                userEntity.getUserPw(),
                userEntity.getUserPhoneNum(),
                userEntity.getUserName(),
                farmName,
                userEntity.getRole()
        );
    }
}
