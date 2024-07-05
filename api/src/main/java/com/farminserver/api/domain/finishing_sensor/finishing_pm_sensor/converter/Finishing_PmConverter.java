package com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.converter;

import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller.model.Finishing_PmResponse;
import com.farminserver.db.finishing_pm_sensor.Finishing_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;
@Component
public class Finishing_PmConverter {

    public Finishing_PmResponse convert(Finishing_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Finishing_PmResponse(
                        entity.getFinishing_Barn_Room_Num(),
                        entity.getFinishing_Pm1_Data(),
                        entity.getFinishing_Pm25_Data(),
                        entity.getFinishing_Pm10_Data(),
                        entity.getFinishing_Total_Pm_Data(),
                        "ppm",
                        entity.getfinishing_Pm_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
