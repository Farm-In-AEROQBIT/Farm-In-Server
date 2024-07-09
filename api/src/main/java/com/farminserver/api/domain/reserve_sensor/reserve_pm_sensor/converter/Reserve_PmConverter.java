package com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.db.reserve_pm_sensor.Reserve_PmSensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Reserve_PmConverter {

    public Boars_PmResponse convert(Reserve_PmSensorEntity pmSensorEntity) {
        return Optional.ofNullable(pmSensorEntity)
                .map(entity -> new Boars_PmResponse(
                        entity.getReserve_Sows_Room_Num(),
                        entity.getReserve_Pm1_Data(),
                        entity.getreserve_Pm25Data(),
                        entity.getReserve_Pm10_Data(),
                        entity.getreserve_TotalPmData(),
                        "ppm",
                        entity.getreserve_Pm_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
