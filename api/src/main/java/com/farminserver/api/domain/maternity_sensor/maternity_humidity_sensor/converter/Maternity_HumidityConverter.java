package com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.converter;

import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.controller.model.Maternity_HumidityResponse;
import com.farminserver.db.maternity_hunmidity_sensor.Maternity_HumiditySensorEntity;
import com.farminserver.db.maternity_hunmidity_sensor.Maternity_HumiditySensorRepository;

import org.springframework.stereotype.Component;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;

import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class Maternity_HumidityConverter {

    public Maternity_HumidityResponse convert(Maternity_HumiditySensorEntity humiditySensorEntity) {
        return Optional.ofNullable(humiditySensorEntity)
                .map(entity -> new Maternity_HumidityResponse(
                        entity.getMaternity_Room_Num(),
                        entity.getMaternity_Humidity_Data(),
                        "%",
                        entity.getMaternity_Humidity_Input_Time().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}