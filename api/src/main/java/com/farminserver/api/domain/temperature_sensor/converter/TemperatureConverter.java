package com.farminserver.api.domain.temperature_sensor.converter;

import com.farminserver.api.domain.temperature_sensor.controller.model.TemperatureResponse;
import com.farminserver.db.boars_temperature_sensor.TemperatureEntity;
import org.springframework.stereotype.Component;

@Component
public class TemperatureConverter {

    public TemperatureResponse convert(double sensorData) {
        String unit = "°C";
        long timestamp = System.currentTimeMillis();
        return new TemperatureResponse(sensorData, unit, timestamp);
    }
}
