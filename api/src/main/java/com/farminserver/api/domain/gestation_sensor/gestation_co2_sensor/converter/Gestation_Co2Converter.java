package com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.converter;

import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller.model.Gestation_Co2Response;
import org.springframework.stereotype.Component;
import com.farminserver.db.gestation_co2_sensor.Gestation_Co2SensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Gestation_Co2Converter {

    public Gestation_Co2Response convert(Gestation_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Gestation_Co2Response(
                        entity.getGestation_Room_Num(),
                        entity.getGestation_Co2_Data(),
                        "ppm",
                        entity.getGestation_Co2_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
