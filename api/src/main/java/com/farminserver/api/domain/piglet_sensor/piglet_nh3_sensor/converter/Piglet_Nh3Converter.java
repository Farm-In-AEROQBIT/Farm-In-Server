package com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.converter;

import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller.model.Piglet_Nh3Response;
import com.farminserver.db.piglet_nh3_sensor.Piglet_Nh3SensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_Nh3Converter {

    public Piglet_Nh3Response convert(Piglet_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Piglet_Nh3Response(
                        entity.getPiglet_Room_Num(),
                        entity.getPiglet_Nh3_Data(),
                        "ppm",
                        entity.getPiglet_Nh3_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
