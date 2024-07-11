package com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.business;

import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.service.Finishing_HumidityService;
import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model.Finishing_HumidityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Finishing_HumidityBusiness {

    private final Finishing_HumidityService finishingHumidityService;

    @Autowired
    public Finishing_HumidityBusiness(Finishing_HumidityService humidityService) {
        this.finishingHumidityService = humidityService;
    }

    public Finishing_HumidityResponse getHumiditySensorData(Long finishingBarnRoomNum) {
        return finishingHumidityService.getHumidityData(finishingBarnRoomNum);
    }

    public List<Finishing_HumidityResponse> getAllHumidityData() {
        return finishingHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        finishingHumidityService.exportHumidityDataToExcel(filePath);
    }
}
