package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.Boars_HumidityResponse;
import com.farminserver.db.boars_humidity_sensor.Boars_HumiditySensorEntity;
import com.farminserver.db.boars_humidity_sensor.Boars_HumiditySensorRepository;
import org.springframework.stereotype.Component;

@Component
public class Boars_HumidityConverter {

    public Boars_HumidityResponse convert(double sensorData) {
        String unit = "%";
        long timestamp = System.currentTimeMillis();
        return new Boars_HumidityResponse(sensorData, unit, timestamp);
    }
}