package com.farminserver.api.domain.co2_sensor.converter;

import com.farminserver.api.domain.co2_sensor.controller.model.Co2Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_co2_sensor.CO2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.util.Optional;

@Component
public class Co2Converter {

    public Co2Response convert(double co2) {
        String unit = "ppm";
        long timestamp = System.currentTimeMillis();
        return new Co2Response(co2, unit, timestamp);
    }

    public Co2Response toResponse(CO2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Co2Response(
                        entity.getCo2Data(),
                        "ppm",
                        entity.getCo2InputTime().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
