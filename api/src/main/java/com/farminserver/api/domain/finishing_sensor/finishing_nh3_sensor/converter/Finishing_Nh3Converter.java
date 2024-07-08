package com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.converter;

import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller.model.Finishing_Nh3Response;
import com.farminserver.db.finishing_nh3_sensor.Finishing_Nh3SensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Finishing_Nh3Converter {

    public Finishing_Nh3Response convert(Finishing_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Finishing_Nh3Response(
                        entity.getFinishing_Room_Num(),
                        entity.getFinishing_Nh3_Data(),
                        "ppm",
                        entity.getfinishing_Nh3InputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
