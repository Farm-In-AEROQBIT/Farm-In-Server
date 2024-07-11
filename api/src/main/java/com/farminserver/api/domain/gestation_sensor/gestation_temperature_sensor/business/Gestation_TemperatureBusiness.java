package com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.business;

import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller.model.Gestation_TemperatureResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.service.Gestation_TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Gestation_TemperatureBusiness {

    private final Gestation_TemperatureService gestationTemperatureService;

    @Autowired
    public Gestation_TemperatureBusiness(Gestation_TemperatureService gestationTemperatureService) {
        this.gestationTemperatureService = gestationTemperatureService;
    }

    public Gestation_TemperatureResponse getTemperatureSensorData(Long gestationRoomNum) {
        return gestationTemperatureService.getTemperatureData(gestationRoomNum);
    }

    public List<Gestation_TemperatureResponse> getAllTemperatureData() {
        return gestationTemperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        gestationTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
