package com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.converter;

import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller.model.Finishing_PmResponse;
import com.farminserver.db.finishing_pm_sensor.Finishing_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;
@Component
public class Finishing_PmConverter {

    public Finishing_PmResponse convert(Finishing_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Finishing_PmResponse(
                        entity.getFinishingBarnRoomNum(),
                        entity.getFinishingPm1Data(),
                        entity.getFinishingPm25Data(),
                        entity.getFinishingPm10Data(),
                        entity.getFinishingTotalPmData(),
                        "ppm",
                        entity.getFinishingPmInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
