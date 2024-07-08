package com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.db.boars_temperature_sensor.Boars_TemperatureSeneorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_co2_sensor.CO2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Maternity_TemperatureConverter {

    public Boars_TemperatureResponse convert(Boars_TemperatureSeneorEntity temperatureSeneorEntity) {
        return Optional.ofNullable(temperatureSeneorEntity)
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
