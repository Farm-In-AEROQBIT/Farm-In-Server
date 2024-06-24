package com.farminserver.api.domain.pm_sensor.converter;

import com.farminserver.api.domain.pm_sensor.controller.model.PmResponse;
import com.farminserver.db.pm_sensor.PmSensorEntity;
import org.springframework.stereotype.Component;

@Component
public class PmConverter {

    public PmResponse convert(double pm1_0, double pm2_5, double pm10, double totalPm) {
        String unit = "㎛";
        long timestamp = System.currentTimeMillis();
        return new PmResponse(pm1_0, pm2_5, pm10, totalPm, unit, timestamp);
    }
}
