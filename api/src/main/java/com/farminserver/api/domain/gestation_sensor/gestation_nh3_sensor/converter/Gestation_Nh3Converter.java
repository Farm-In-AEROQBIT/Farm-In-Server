package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_co2_sensor.CO2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.util.Optional;

@Component
public class Gestation_Nh3Converter {

    public UserResponse convert(double co2) {
        String unit = "ppm";
        long timestamp = System.currentTimeMillis();
        return new UserResponse(co2, unit, timestamp);
    }

    public UserResponse toResponse(CO2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new UserResponse(
                        entity.getCo2Data(),
                        "ppm",
                        entity.getCo2InputTime().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
