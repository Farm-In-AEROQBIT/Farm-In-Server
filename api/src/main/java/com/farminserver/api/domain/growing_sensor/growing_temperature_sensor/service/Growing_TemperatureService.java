package com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.service;

import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller.model.Growing_TemperatureResponse;
import com.farminserver.db.growing_temperature_sensor.Growing_TemperatureSensorEntity;
import com.farminserver.db.growing_temperature_sensor.Growing_TemperatureSensorRepository;
import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.converter.Growing_TemperatureConverter;
import com.farminserver.api.util.ExcelExporter.Growing_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Growing_TemperatureService {

    private final Growing_TemperatureSensorRepository repository;
    private final Growing_TemperatureConverter converter;
    private final Growing_ExcelExporter excelExporter;

    @Autowired
    public Growing_TemperatureService(Growing_TemperatureSensorRepository repository, Growing_TemperatureConverter converter, Growing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Growing_TemperatureResponse getTemperatureData(Long growingRoomNum) {
        Growing_TemperatureSensorEntity entity = repository.findById(growingRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Growing_TemperatureResponse> getAllTemperatureData() {
        List<Growing_TemperatureSensorEntity> entities = repository.findAll();
        List<Growing_TemperatureResponse> responses = new ArrayList<>();
        for (Growing_TemperatureSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Growing_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportGrowing_TemperatureData(responses, filePath);
    }
}
