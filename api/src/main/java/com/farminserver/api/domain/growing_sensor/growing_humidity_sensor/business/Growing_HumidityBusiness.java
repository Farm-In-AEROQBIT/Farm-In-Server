package com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.business;

import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller.model.Growing_HumidityResponse;
import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.service.Growing_HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Growing_HumidityBusiness {

    private final Growing_HumidityService growingHumidityService;

    @Autowired
    public Growing_HumidityBusiness(Growing_HumidityService humidityService) {
        this.growingHumidityService = humidityService;
    }

    public Growing_HumidityResponse getHumiditySensorData(Long growingBarnRoomNum) {
        return growingHumidityService.getHumidityData(growingBarnRoomNum);
    }

    public List<Growing_HumidityResponse> getAllHumidityData() {
        return growingHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        growingHumidityService.exportHumidityDataToExcel(filePath);
    }
}
