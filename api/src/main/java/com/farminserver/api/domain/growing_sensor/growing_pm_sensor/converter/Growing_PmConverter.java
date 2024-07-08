package com.farminserver.api.domain.growing_sensor.growing_pm_sensor.converter;

import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.controller.model.Growing_PmResponse;
import com.farminserver.db.growing_pm_sensor.Growing_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Growing_PmConverter {

    public Growing_PmResponse convert(Growing_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Growing_PmResponse(
                        entity.getGrowing_Room_Num(),
                        entity.getGrowing_Pm1_Data(),
                        entity.getGrowing_Pm25_Data(),
                        entity.getGrowing_Pm10_Data(),
                        entity.getGrowing_Total_Pm_Data(),
                        "ppm",
                        entity.growing_Pm_Input_Time.toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
