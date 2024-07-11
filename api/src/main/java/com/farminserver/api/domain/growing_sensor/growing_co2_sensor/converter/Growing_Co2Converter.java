package com.farminserver.api.domain.growing_sensor.growing_co2_sensor.converter;

import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller.model.Growing_Co2Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.growing_co2_sensor.Growing_Co2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Growing_Co2Converter {

    public Growing_Co2Response convert(Growing_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Growing_Co2Response(
                        entity.getGrowing_Room_Num(),
                        entity.getGrowing_Co2_Data(),
                        "ppm",
                        entity.getGrowing_Co2_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
