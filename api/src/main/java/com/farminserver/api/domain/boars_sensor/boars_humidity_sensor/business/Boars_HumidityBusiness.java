package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.Boars_HumidityResponse;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.converter.Boars_HumidityConverter;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.service.Boars_HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Boars_HumidityBusiness {

    private final Boars_HumidityService boarsHumidityService;
    private final Boars_HumidityConverter boarsHumidityConverter;

    @Autowired
    public Boars_HumidityBusiness(Boars_HumidityService boarsHumidityService, Boars_HumidityConverter boarsHumidityConverter) {
        this.boarsHumidityService = boarsHumidityService;
        this.boarsHumidityConverter = boarsHumidityConverter;
    }

    public Boars_HumidityResponse getHumiditySensorData() {
        double humidityData = boarsHumidityService.getHumidityData();
        return boarsHumidityConverter.convert(humidityData);
    }

    public List<Boars_HumidityResponse> getAllHumidityData() {
        return boarsHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        boarsHumidityService.exportHumidityDataToExcel(filePath);
    }
}
