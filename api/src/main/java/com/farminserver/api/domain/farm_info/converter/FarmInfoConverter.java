package com.farminserver.api.domain.farm_info.converter;

import com.farminserver.api.domain.farm_info.controller.model.FarmInfoResponse;
import com.farminserver.db.farm_info.FarmInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class FarmInfoConverter {

    public FarmInfoResponse toResponse(FarmInfoEntity farmInfoEntity) {
        if (farmInfoEntity == null) {
            return null;
        }
        return new FarmInfoResponse(
                farmInfoEntity.getFarmName()
        );
    }
}
