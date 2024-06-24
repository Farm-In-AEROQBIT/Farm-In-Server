package com.farminserver.api.domain.humidity_sensor.business;

import com.farminserver.api.domain.humidity_sensor.controller.model.HumidityResponse;
import com.farminserver.api.domain.humidity_sensor.converter.HumidityConverter;
import com.farminserver.api.domain.humidity_sensor.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class HumidityBusiness {

    private final HumidityService humidityService;
    private final HumidityConverter humidityConverter;

    @Autowired
    public HumidityBusiness(HumidityService humidityService, HumidityConverter humidityConverter) {
        this.humidityService = humidityService;
        this.humidityConverter = humidityConverter;
    }

    public HumidityResponse getHumiditySensorData() {
        double humidityData = humidityService.getHumidityData();
        return humidityConverter.convert(humidityData);
    }

    public List<HumidityResponse> getAllHumidityData() {
        return humidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        humidityService.exportHumidityDataToExcel(filePath);
    }
}
