package com.farminserver.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserError implements ErrorCodeIfs{
    AUTHORIZATION_ACCESS_NOT_FOUNT(400,2005,"승인 되지 않은 관리자입니다.");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
