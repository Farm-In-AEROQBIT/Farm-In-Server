package com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.business;

import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller.model.Piglet_TemperatureResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.service.Piglet_TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_TemperatureBusiness {

    private final Piglet_TemperatureService pigletTemperatureService;

    @Autowired
    public Piglet_TemperatureBusiness(Piglet_TemperatureService pigletTemperatureService) {
        this.pigletTemperatureService = pigletTemperatureService;
    }
    public Piglet_TemperatureResponse getTemperatureSensorData(Long pigletRoomNum) {
        return pigletTemperatureService.getTemperatureData(pigletRoomNum);
    }

    public List<Piglet_TemperatureResponse> getAllTemperatureData() {
        return pigletTemperatureService.getAllTemperatureData();
    }
    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        pigletTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
