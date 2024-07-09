package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_temperature_sensor.Boars_TemperatureSensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Boars_TemperatureConverter {

    public Boars_TemperatureResponse convert(Boars_TemperatureSensorEntity temperatureSensorEntity) {
        return Optional.ofNullable(temperatureSensorEntity)
                .map(entity -> new Boars_TemperatureResponse(
                        entity.getBoarsBarnRoomNum(),
                        entity.getBoarsTemperData(),
                        "°C",
                        entity.getBoarsTemperLocateData(),
                        entity.getBoarsTemperInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
