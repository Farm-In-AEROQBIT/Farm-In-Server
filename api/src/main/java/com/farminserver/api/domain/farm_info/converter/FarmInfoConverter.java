package com.farminserver.api.domain.farm_info.converter;

import com.farminserver.api.common.annotation.Converter;
import com.farminserver.db.farm_info.FarmInfoEntity;
import com.farminserver.api.domain.farm_info.controller.model.FarmInfoResponse;
import org.springframework.stereotype.Component;

@Component
@Converter
public class FarmInfoConverter {
    public FarmInfoResponse toResponse(FarmInfoEntity farmInfoEntity) {
        if (farmInfoEntity == null) {
            return null;
        }
        return new FarmInfoResponse(
                farmInfoEntity.getUser_phone_num(), farmInfoEntity.getFarm_name()
        );
    }
}
