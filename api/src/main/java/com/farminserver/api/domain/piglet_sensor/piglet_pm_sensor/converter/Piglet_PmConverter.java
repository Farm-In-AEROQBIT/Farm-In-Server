package com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.converter;

import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller.model.Piglet_PmResponse;
import com.farminserver.db.piglet_pm_sensor.Piglet_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_PmConverter {

    public Piglet_PmResponse convert(Piglet_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Piglet_PmResponse(
                        entity.getPiglet_Barn_Room_Num(),
                        entity.getPiglet_Pm1_Data(),
                        entity.getPiglet_Pm25_Data(),
                        entity.getPiglet_Pm10_Data(),
                        entity.getPiglet_Total_Pm_Data(),
                        "ppm",
                        entity.getpiglet_Pm_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
