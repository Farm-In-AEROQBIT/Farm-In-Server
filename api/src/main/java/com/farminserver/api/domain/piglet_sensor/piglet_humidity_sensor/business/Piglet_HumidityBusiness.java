package com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.business;

import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller.model.Piglet_HumidityResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.service.Piglet_HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_HumidityBusiness {

    private final Piglet_HumidityService pigletHumidityService;

    @Autowired
    public Piglet_HumidityBusiness(Piglet_HumidityService humidityService) {
        this.pigletHumidityService = humidityService;
    }

    public Piglet_HumidityResponse getHumiditySensorData(Long pigletRoomNum) {
        return pigletHumidityService.getHumidityData(pigletRoomNum);
    }

    public List<Piglet_HumidityResponse> getAllHumidityData() {
        return pigletHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        pigletHumidityService.exportHumidityDataToExcel(filePath);
    }
}
