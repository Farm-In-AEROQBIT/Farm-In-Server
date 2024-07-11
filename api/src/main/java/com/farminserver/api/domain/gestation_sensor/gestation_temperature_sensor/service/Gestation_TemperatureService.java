package com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.service;

import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller.model.Gestation_TemperatureResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.converter.Gestation_TemperatureConverter;
import com.farminserver.api.util.Gestation_ExcelExporter;
import com.farminserver.db.gestation_temperature_sensor.Gestation_TemperatureSensorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farminserver.db.gestation_temperature_sensor.Gestation_TemperatureSensorRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gestation_TemperatureService {

    private final Gestation_TemperatureSensorRepository repository;
    private final Gestation_TemperatureConverter converter;
    private final Gestation_ExcelExporter excelExporter;

    @Autowired
    public Gestation_TemperatureService(Gestation_TemperatureSensorRepository repository, Gestation_TemperatureConverter converter, Gestation_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Gestation_TemperatureResponse getTemperatureData(Long gestationRoomNum) {
        Gestation_TemperatureSensorEntity entity = repository.findById(gestationRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Gestation_TemperatureResponse> getAllTemperatureData() {
        List<Gestation_TemperatureSensorEntity> entities = repository.findAll();
        List<Gestation_TemperatureResponse> responses = new ArrayList<>();
        for (Gestation_TemperatureSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Gestation_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportGestation_TemperatureData(responses, filePath);
    }
}
