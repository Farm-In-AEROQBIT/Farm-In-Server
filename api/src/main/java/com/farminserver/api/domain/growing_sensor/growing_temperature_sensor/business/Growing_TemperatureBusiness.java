package com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.business;

import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller.model.Growing_TemperatureResponse;
import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.service.Growing_TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Growing_TemperatureBusiness {

    private final Growing_TemperatureService growingTemperatureService;

    @Autowired
    public Growing_TemperatureBusiness(Growing_TemperatureService growingTemperatureService) {
        this.growingTemperatureService = growingTemperatureService;
    }

    public Growing_TemperatureResponse getTemperatureSensorData(Long growingRoomNum) {
        return growingTemperatureService.getTemperatureData(growingRoomNum);
    }

    public List<Growing_TemperatureResponse> getAllTemperatureData() {
        return growingTemperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        growingTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
