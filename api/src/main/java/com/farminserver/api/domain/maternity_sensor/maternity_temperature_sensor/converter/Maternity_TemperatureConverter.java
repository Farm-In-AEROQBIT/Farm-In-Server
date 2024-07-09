package com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.converter;

import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.controller.model.Maternity_TemperatureResponse;
import com.farminserver.db.maternity_temperature_sensor.Maternity_TemperatureSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Maternity_TemperatureConverter {

    public Maternity_TemperatureResponse convert(Maternity_TemperatureSensorEntity temperatureSeneorEntity) {
        return Optional.ofNullable(temperatureSeneorEntity)
                .map(entity -> new Maternity_TemperatureResponse(
                        entity.getMaternityRoomNum(),
                        entity.getMaternityTemperData(),
                        "°C",
                        entity.getMaternityTemperLocateData(),
                        entity.getMaternityTemperInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
