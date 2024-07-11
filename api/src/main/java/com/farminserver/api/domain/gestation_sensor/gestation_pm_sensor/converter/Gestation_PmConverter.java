package com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.converter;

import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller.model.Gestation_PmResponse;
import com.farminserver.db.gestation_pm_sensor.Gestation_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Gestation_PmConverter {

    public Gestation_PmResponse convert(Gestation_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Gestation_PmResponse(
                        entity.getGestationRoomNum(),
                        entity.getGestationPm1Data(),
                        entity.getGestationPm25Data(),
                        entity.getGestationPm10Data(),
                        entity.getGestationTotalPmData(),
                        "ppm",
                        entity.getGestationPmInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
