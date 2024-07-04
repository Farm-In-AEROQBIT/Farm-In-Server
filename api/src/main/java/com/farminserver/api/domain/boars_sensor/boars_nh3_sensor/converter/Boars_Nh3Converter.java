package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_nh3_sensor.Boars_Nh3SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Boars_Nh3Converter {

    public Boars_Nh3Response convert(Boars_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Boars_Nh3Response(
                        entity.getBoars_Barn_Room_Num(),
                        entity.getBoars_Nh3_Data(),
                        "ppm",
                        entity.getBoars_Nh3_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
