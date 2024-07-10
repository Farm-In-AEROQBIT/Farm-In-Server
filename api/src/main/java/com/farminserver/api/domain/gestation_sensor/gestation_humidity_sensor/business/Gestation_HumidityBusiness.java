package com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.business;

import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller.model.Gestation_HumidityResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.service.Gestation_HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Gestation_HumidityBusiness {

    private final Gestation_HumidityService gestationHumidityService;

    @Autowired
    public Gestation_HumidityBusiness(Gestation_HumidityService humidityService) {
        this.gestationHumidityService = humidityService;
    }

    public Gestation_HumidityResponse getHumiditySensorData(Long gestationBarnRoomNum) {
        return gestationHumidityService.getHumidityData(gestationBarnRoomNum);
    }

    public List<Gestation_HumidityResponse> getAllHumidityData() {
        return gestationHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        gestationHumidityService.exportHumidityDataToExcel(filePath);
    }
}
