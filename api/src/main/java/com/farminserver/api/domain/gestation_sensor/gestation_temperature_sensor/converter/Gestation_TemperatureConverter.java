package com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.converter;

import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller.model.Gestation_TemperatureResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.gestation_temperature_sensor.Gestation_TemperatureSensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Gestation_TemperatureConverter {

    public Gestation_TemperatureResponse convert(Gestation_TemperatureSensorEntity temperatureSeneorEntity) {
        return Optional.ofNullable(temperatureSeneorEntity)
                .map(entity -> new Gestation_TemperatureResponse(
                        entity.getGestationRoomNum(),
                        entity.getGestationTemperData(),
                        "°C",
                        entity.getGestationTemperLocateData(),
                        entity.getGestationTemperInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}