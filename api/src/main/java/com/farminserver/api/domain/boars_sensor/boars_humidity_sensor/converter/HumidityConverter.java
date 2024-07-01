package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.HumidityResponse;
import com.farminserver.db.boars_humidity_sensor.HumiditySensorEntity;
import org.springframework.stereotype.Component;

@Component
public class HumidityConverter {

    public HumidityResponse convert(double sensorData) {
        String unit = "%";
        long timestamp = System.currentTimeMillis();
        return new HumidityResponse(sensorData, unit, timestamp);
    }
}