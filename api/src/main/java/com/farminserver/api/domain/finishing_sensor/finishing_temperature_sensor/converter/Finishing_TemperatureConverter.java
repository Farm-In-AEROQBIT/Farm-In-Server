package com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller.model.Finishing_TemperatureResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.finishing_temperature_sensor.Finishing_TemperatureSeneorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Finishing_TemperatureConverter {

    public Finishing_TemperatureResponse convert(Finishing_TemperatureSeneorEntity temperatureSeneorEntity) {
        return Optional.ofNullable(temperatureSeneorEntity)
                .map(entity -> new Finishing_TemperatureResponse(
                        entity.getFinishingBarnRoomNum(),
                        entity.getFinishingTemperData(),
                        "°C",
                        entity.getFinishingTemperLocateData(),
                        entity.getFinishingTemperInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
