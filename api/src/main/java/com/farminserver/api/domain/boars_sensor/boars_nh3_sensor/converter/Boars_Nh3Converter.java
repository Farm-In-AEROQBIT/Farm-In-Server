package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Maternity_Nh3Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_nh3_sensor.Maternity_Nh3SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Maternity_Nh3Converter {

    public Maternity_Nh3Response convert(Maternity_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Maternity_Nh3Response(
                        entity.getBoars_Barn_Room_Num(),
                        entity.getBoars_Nh3_Data(),
                        "ppm",
                        entity.getBoars_Nh3_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
