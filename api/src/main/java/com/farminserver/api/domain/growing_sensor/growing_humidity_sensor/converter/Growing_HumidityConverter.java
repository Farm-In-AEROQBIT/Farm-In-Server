package com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.converter;

import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller.model.Growing_HumidityResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.growing_humidity_sensor.Growing_HumiditySensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Growing_HumidityConverter {

    public Growing_HumidityResponse convert(Growing_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Growing_HumidityResponse(
                        entity.getGrowing_Room_Num(),
                        entity.getGrowing_Humidity_Data(),
                        "%",
                        entity.getgrowing_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
