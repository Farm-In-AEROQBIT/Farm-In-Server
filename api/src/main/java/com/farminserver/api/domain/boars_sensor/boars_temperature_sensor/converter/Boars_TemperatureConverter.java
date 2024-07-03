package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.db.boars_temperature_sensor.TemperatureEntity;
import org.springframework.stereotype.Component;

@Component
public class Boars_TemperatureConverter {

    public Boars_TemperatureResponse convert(double sensorData) {
        String unit = "°C";
        long timestamp = System.currentTimeMillis();
        return new Boars_TemperatureResponse(sensorData, unit, timestamp);
    }
}
