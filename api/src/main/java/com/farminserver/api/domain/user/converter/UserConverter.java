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

        return new UserResponse(
                userEntity.getUserId(),
                userEntity.getUserPw(),
                userEntity.getUser_phone_num(),
                userEntity.getUserName(),
                userEntity.getFarm_name()
        );
    }
}
