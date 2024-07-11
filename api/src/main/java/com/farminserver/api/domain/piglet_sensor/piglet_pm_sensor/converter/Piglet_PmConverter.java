package com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.converter;

import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller.model.Piglet_PmResponse;
import com.farminserver.db.piglet_pm_sensor.Piglet_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_PmConverter {

    public Piglet_PmResponse convert(Piglet_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Piglet_PmResponse(
                        entity.getPigletBarnRoomNum(),
                        entity.getPigletPm1Data(),
                        entity.getPigletPm25Data(),
                        entity.getPigletPm1Data(),
                        entity.getPigletTotalPmData(),
                        "ppm",
                        entity.getPigletPmInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
