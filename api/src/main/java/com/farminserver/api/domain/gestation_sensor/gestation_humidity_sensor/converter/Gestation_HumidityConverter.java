package com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.converter;

import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller.model.Gestation_HumidityResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.gestation_humidity_sensor.Gestation_HumiditySensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Gestation_HumidityConverter {

    public Gestation_HumidityResponse convert(Gestation_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Gestation_HumidityResponse(
                        entity.getGestation_Room_Num(),
                        entity.getGestation_Humidity_Data(),
                        "%",
                        entity.getgestation_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
