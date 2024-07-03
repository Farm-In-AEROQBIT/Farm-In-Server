package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.db.boars_pm_sensor.PmSensorEntity;
import org.springframework.stereotype.Component;

@Component
public class Boars_PmConverter {

    public Boars_PmResponse convert(double pm1_0, double pm2_5, double pm10, double totalPm) {
        String unit = "㎛";
        long timestamp = System.currentTimeMillis();
        return new Boars_PmResponse(pm1_0, pm2_5, pm10, totalPm, unit, timestamp);
    }
}
