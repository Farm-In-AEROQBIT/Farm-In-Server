package com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.converter;

import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.controller.model.Reserve_Co2Response;
import com.farminserver.db.reserve_co2_sensor.Reserve_Co2SensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Reserve_Co2Converter {

    public Reserve_Co2Response convert(Reserve_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Reserve_Co2Response(
                        entity.getReserve_Sows_Room_Num(),
                        entity.getReserve_Co2_Data(),
                        "ppm",
                        entity.getReserve_Co2_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
