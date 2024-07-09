package com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.service;

import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller.model.Piglet_TemperatureResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.converter.Piglet_TemperatureConverter;
import com.farminserver.api.util.Piglet_ExcelExporter;
import com.farminserver.db.piglet_temperature_sensor.Piglet_TemperatureSensorEntity;
import com.farminserver.db.piglet_temperature_sensor.Piglet_TemperatureSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Piglet_TemperatureService {

    private final Piglet_TemperatureSensorRepository repository;
    private final Piglet_TemperatureConverter converter;
    private final Piglet_ExcelExporter excelExporter;

    @Autowired
    public Piglet_TemperatureService(Piglet_TemperatureSensorRepository repository, Piglet_TemperatureConverter converter, Piglet_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Piglet_TemperatureResponse getTemperatureData(String pigletRoomNum) {
        Piglet_TemperatureSensorEntity entity = repository.findById(pigletRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Piglet_TemperatureResponse> getAllTemperatureData() {
        List<Piglet_TemperatureSensorEntity> entities = repository.findAll();
        List<Piglet_TemperatureResponse> responses = new ArrayList<>();
        for (Piglet_TemperatureSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Piglet_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportPiglet_TemperatureData(responses, filePath);
    }
}
