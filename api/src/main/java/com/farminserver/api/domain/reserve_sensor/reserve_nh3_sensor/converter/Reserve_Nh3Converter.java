package com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.converter;

import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller.model.Reserve_Nh3Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.reserve_nh3_sensor.Reserve_Nh3SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Reserve_Nh3Converter {

    public Reserve_Nh3Response convert(Reserve_Nh3SensorEntity nh3SensorEntity) {
        return Optional.ofNullable(nh3SensorEntity)
                .map(entity -> new Reserve_Nh3Response(
                        entity.getReserve_Sows_Room_Num(),
                        entity.getReserve_Nh3_Data(),
                        "ppm",
                        entity.getReserve_Nh3_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
