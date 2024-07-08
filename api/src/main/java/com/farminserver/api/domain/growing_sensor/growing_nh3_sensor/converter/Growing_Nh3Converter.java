package com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.converter;

import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller.model.Growing_Nh3Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.growing_nh3_sensor.Growing_Nh3SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Growing_Nh3Converter {

    public Growing_Nh3Response convert(Growing_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Growing_Nh3Response(
                        entity.getGrowing_Room_Num(),
                        entity.getGrowing_Nh3_Data(),
                        "ppm",
                        entity.getGrowing_Nh3_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
