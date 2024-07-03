package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.service.Boars_TemperatureService;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.converter.Boars_TemperatureConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Boars_TemperatureBusiness {

    private final Boars_TemperatureService boarsTemperatureService;
    private final Boars_TemperatureConverter boarsTemperatureConverter;

    @Autowired
    public Boars_TemperatureBusiness(Boars_TemperatureService boarsTemperatureService, Boars_TemperatureConverter boarsTemperatureConverter) {
        this.boarsTemperatureService = boarsTemperatureService;
        this.boarsTemperatureConverter = boarsTemperatureConverter;
    }

    public Boars_TemperatureResponse getTemperatureSensorData() {
        double temperatureData = boarsTemperatureService.getTemperatureData();
        return boarsTemperatureConverter.convert(temperatureData);
    }

    public List<Boars_TemperatureResponse> getAllTemperatureData() {
        return boarsTemperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        boarsTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
