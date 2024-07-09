package com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.converter;

import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.controller.model.Maternity_PmResponse;
import com.farminserver.db.maternity_pm_sensor.Maternity_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Maternity_PmConverter {

    public Maternity_PmResponse convert(Maternity_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Maternity_PmResponse(
                        entity.getMaternity_Room_Num(),
                        entity.getMaternity_Pm1_Data(),
                        entity.getMaternity_Pm25_Data(),
                        entity.getMaternity_Pm10_Data(),
                        entity.getMaternity_Total_Pm_Data(),
                        "ppm",
                        entity.getmaternity_Pm_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
