package com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.converter;

import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller.model.Growing_TemperatureResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.growing_temperature_sensor.Growing_TemperatureSensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Growing_TemperatureConverter {

    public Growing_TemperatureResponse convert(Growing_TemperatureSensorEntity temperatureSeneorEntity) {
        return Optional.ofNullable(temperatureSeneorEntity)
                .map(entity -> new Growing_TemperatureResponse(
                        entity.getGrowingRoomNum(),
                        entity.getGrowingTemperData(),
                        "°C",
                        entity.getGrowingTemperLocateData(),
                        entity.getGrowingTemperInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
