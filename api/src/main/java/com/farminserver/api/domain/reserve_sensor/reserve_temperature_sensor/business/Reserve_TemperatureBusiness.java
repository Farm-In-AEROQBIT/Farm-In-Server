package com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.business;

import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.controller.model.Reserve_TemperatureResponse;
import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.service.Reserve_TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Reserve_TemperatureBusiness {

    private final Reserve_TemperatureService reserveTemperatureService;

    @Autowired
    public Reserve_TemperatureBusiness(Reserve_TemperatureService reserveTemperatureService) {
        this.reserveTemperatureService = reserveTemperatureService;
    }

    public Reserve_TemperatureResponse getTemperatureSensorData(Long reserveSowsRoomNum) {
        return reserveTemperatureService.getTemperatureData(reserveSowsRoomNum);
    }

    public List<Reserve_TemperatureResponse> getAllTemperatureData() {
        return reserveTemperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        reserveTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
