package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.converter;

import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller.model.Piglet_Co2Response;
import com.farminserver.db.piglet_co2_sensor.Piglet_Co2SensorEntity;
import org.springframework.stereotype.Component;

import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_Co2Converter {

    public Piglet_Co2Response convert(Piglet_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Piglet_Co2Response(
                        entity.getFarmName(),
                        entity.getpiglet_Co2Data(),
                        "ppm",
                        entity.getCo2InputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
