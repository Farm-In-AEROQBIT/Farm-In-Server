package com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.Boars_HumidityResponse;
import com.farminserver.db.boars_humidity_sensor.Boars_HumiditySensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_co2_sensor.CO2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Piglet_HumidityConverter {

    public Boars_HumidityResponse convert(Boars_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Boars_HumidityResponse(
                        entity.getBoars_Barn_Room_Num(),
                        entity.getBoars_Humidity_Data(),
                        "%",
                        entity.getboars_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}