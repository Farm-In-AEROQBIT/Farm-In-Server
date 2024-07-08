package com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.converter;

import com.farminserver.api.common.error.ErrorCode;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller.model.Finishing_Co2Response;
import com.farminserver.db.finishing_co2_sensor.Finishing_Co2SensorEntity;
import org.springframework.stereotype.Component;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Finishing_Co2Converter {

    public Finishing_Co2Response convert(Finishing_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Finishing_Co2Response(
                        entity.getFinishing_Barn_Room_Num(),
                        entity.getFinishing_Co2_Data(),
                        "ppm",
                        entity.getFinishing_Co2_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
