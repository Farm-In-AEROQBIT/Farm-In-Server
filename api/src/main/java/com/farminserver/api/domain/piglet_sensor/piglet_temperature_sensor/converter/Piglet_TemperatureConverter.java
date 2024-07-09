package com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.converter;

import com.farminserver.db.piglet_temperature_sensor.Piglet_TemperatureSensorEntity;
import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller.model.Piglet_TemperatureResponse;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_TemperatureConverter {

    public Piglet_TemperatureResponse convert(Piglet_TemperatureSensorEntity temperatureSensorEntity) {
        return Optional.ofNullable(temperatureSensorEntity)
                .map(entity -> new Piglet_TemperatureResponse(
                        entity.getPigletRoomNum(),
                        entity.getPigletTemperData(),
                        "°C",
                        entity.getPigletTemperLocateData(),
                        entity.getPigletTemperInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
