package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorEntity;
import com.farminserver.db.boars_pm_sensor.Boars_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Boars_PmConverter {

    public Boars_PmResponse convert(Boars_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Boars_PmResponse(
                        entity.getBoars_Barn_Room_Num(),
                        entity.getBoars_Pm1_Data(),
                        entity.getBoars_Pm25_Data(),
                        entity.getBoars_Pm10_Data(),
                        entity.getBoars_Total_Pm_Data(),
                        "ppm",
                        entity.getboars_Pm_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
