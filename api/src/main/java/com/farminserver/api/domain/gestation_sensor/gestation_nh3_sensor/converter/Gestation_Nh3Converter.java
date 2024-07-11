package com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.converter;

import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller.model.Gestation_Nh3Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.gestation_nh3_sensor.Gestation_Nh3SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Gestation_Nh3Converter {

    public Gestation_Nh3Response convert(Gestation_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Gestation_Nh3Response(
                        entity.getGestation_Room_Num(),
                        entity.getGestation_Nh3_Data(),
                        "ppm",
                        entity.getGestation_Nh3_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
