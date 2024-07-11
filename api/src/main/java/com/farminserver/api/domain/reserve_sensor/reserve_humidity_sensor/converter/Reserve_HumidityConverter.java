package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.converter;

import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller.model.Reserve_HumidityResponse;
import com.farminserver.db.reserve_humidity_sensor.Reserve_HumiditySensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Reserve_HumidityConverter {

    public Reserve_HumidityResponse convert(Reserve_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Reserve_HumidityResponse(
                        entity.getReserve_Sows_Room_Num(),
                        entity.getreserve_HumidityData(),
                        "%",
                        entity.getreserve_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}