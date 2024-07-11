package com.farminserver.api.domain.user.converter;

import com.farminserver.api.domain.user.controller.model.UserResponse;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.annotation.Converter;
import com.farminserver.db.user.UserEntity;

import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.util.Optional;

@Converter
@Component
public class UserConverter {

    public UserResponse toResponse(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return new UserResponse(
                userEntity.getUserId(), userEntity.getUserPw(), userEntity.getUserName(), userEntity.getUser_phone_num(), userEntity.getFarm_name()
        );
    }

}
