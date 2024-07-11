package com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.converter;

import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.controller.model.Reserve_PmResponse;
import com.farminserver.db.reserve_pm_sensor.Reserve_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Reserve_PmConverter {

    public Reserve_PmResponse convert(Reserve_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Reserve_PmResponse(
                        entity.getReserveSowsRoomNum(),
                        entity.getReservePm1Data(),
                        entity.getReservePm25Data(),
                        entity.getReservePm10Data(),
                        entity.getReserveTotalPmData(),
                        "ppm",
                        entity.getReservePmInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
