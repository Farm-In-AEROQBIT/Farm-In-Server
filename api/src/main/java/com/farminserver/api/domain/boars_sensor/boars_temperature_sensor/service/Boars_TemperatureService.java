package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.db.boars_temperature_sensor.Boars_TemperatureSensorEntity;
import com.farminserver.db.boars_temperature_sensor.Boars_TemperatureSensorRepository;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.converter.Boars_TemperatureConverter;
import com.farminserver.api.util.Boars_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_TemperatureService {

    private final Boars_TemperatureSensorRepository repository;
    private final Boars_TemperatureConverter converter;
    private final Boars_ExcelExporter excelExporter;

    @Autowired
    public Boars_TemperatureService(Boars_TemperatureSensorRepository repository, Boars_TemperatureConverter converter, Boars_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Boars_TemperatureResponse getTemperatureData(Long boarsBarnRoomNum) {
        Boars_TemperatureSensorEntity entity = repository.findById(boarsBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Boars_TemperatureResponse> getAllTemperatureData() {
        List<Boars_TemperatureSensorEntity> entities = repository.findAll();
        List<Boars_TemperatureResponse> responses = new ArrayList<>();
        for (Boars_TemperatureSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Boars_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportBoars_TemperatureData(responses, filePath);
    }
}
