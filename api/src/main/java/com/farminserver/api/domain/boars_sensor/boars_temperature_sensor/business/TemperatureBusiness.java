package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.TemperatureResponse;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.service.TemperatureService;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.converter.TemperatureConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TemperatureBusiness {

    private final TemperatureService temperatureService;
    private final TemperatureConverter temperatureConverter;

    @Autowired
    public TemperatureBusiness(TemperatureService temperatureService, TemperatureConverter temperatureConverter) {
        this.temperatureService = temperatureService;
        this.temperatureConverter = temperatureConverter;
    }

    public TemperatureResponse getTemperatureSensorData() {
        double temperatureData = temperatureService.getTemperatureData();
        return temperatureConverter.convert(temperatureData);
    }

    public List<TemperatureResponse> getAllTemperatureData() {
        return temperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        temperatureService.exportTemperatureDataToExcel(filePath);
    }
}
