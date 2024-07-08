package com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.converter;

import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller.model.Piglet_HumidityResponse;
import com.farminserver.db.piglet_humidity_sensor.Piglet_HumiditySensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_HumidityConverter {

    public Piglet_HumidityResponse convert(Piglet_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Piglet_HumidityResponse(
                        entity.getFarmName(),
                        entity.getPiglet_Humidity_Data(),
                        "%",
                        entity.getpiglet_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}