package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.business;

import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller.model.Reserve_HumidityResponse;
import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.service.Reserve_HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Reserve_HumidityBusiness {

    private final Reserve_HumidityService reserveHumidityService;

    @Autowired
    public Reserve_HumidityBusiness(Reserve_HumidityService humidityService) {
        this.reserveHumidityService = humidityService;
    }

    public Reserve_HumidityResponse getHumiditySensorData(String reserveBarnRoomNum) {
        return reserveHumidityService.getHumidityData(reserveBarnRoomNum);
    }

    public List<Reserve_HumidityResponse> getAllHumidityData() {
        return reserveHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        reserveHumidityService.exportHumidityDataToExcel(filePath);
    }
}
