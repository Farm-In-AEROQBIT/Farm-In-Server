package com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.converter;

import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model.Finishing_HumidityResponse;
import com.farminserver.db.finishing_humidity_sensor.Finishing_HumiditySensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Finishing_HumidityConverter {

    public Finishing_HumidityResponse convert(Finishing_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Finishing_HumidityResponse(
                        entity.getFinishing_Barn_Room_Num(),
                        entity.getfinishing_HumidityData(),
                        "%",
                        entity.getfinishing_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
