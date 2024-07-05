package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.converter;


import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller.model.Martenity_Co2Response;
import com.farminserver.db.maternity_co2_sensor.Maternity_Co2SensorEntity;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Maternity_Co2Converter {

    public Martenity_Co2Response convert(Maternity_Co2SensorEntity co2SensorEntity) {
        return Optional.ofNullable(co2SensorEntity)
                .map(entity -> new Martenity_Co2Response(
                        entity.getMaternity_Room_Num(),
                        entity.getmaternity_Co2Data(),
                        "ppm",
                        entity.getCo2InputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
