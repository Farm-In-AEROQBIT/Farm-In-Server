package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.converter;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boar_Co2Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Boars_Co2Converter {

    public Boar_Co2Response convert(Boars_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Boar_Co2Response(
                        entity.getBoars_Barn_Room_Num(),
                        entity.getBoarsCo2Data(),
                        "ppm",
                        entity.getBoarsCo2InputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
