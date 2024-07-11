package com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.converter;

import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.controller.model.Reserve_TemperatureResponse;
import org.springframework.stereotype.Component;
import com.farminserver.db.reserve_temperature_sensor.Reserve_TemperatureSensorEntity;
import com.farminserver.api.common.exception.ApiException;
import com.farminserver.api.common.error.ErrorCode;
import java.time.ZoneOffset;

import java.util.Optional;

@Component
public class Reserve_TemperatureConverter {

    public Reserve_TemperatureResponse convert(Reserve_TemperatureSensorEntity temperatureSensorEntity) {
        return Optional.ofNullable(temperatureSensorEntity)
                .map(entity -> new Reserve_TemperatureResponse(
                        entity.getReserveSowsRoomNum(),
                        entity.getReserveTemperatureData(),
                        "°C",
                        entity.getReserveTemperatureLocateData(),
                        entity.getReserveTemperatureInputTime().toEpochSecond(ZoneOffset.UTC)
                ))
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
