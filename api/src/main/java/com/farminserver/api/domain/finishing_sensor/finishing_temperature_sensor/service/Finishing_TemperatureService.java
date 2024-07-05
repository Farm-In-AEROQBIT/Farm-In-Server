package com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.service;

import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller.model.Finishing_TemperatureResponse;
import com.farminserver.db.finishing_temperature_sensor.Finishing_TemperatureSeneorEntity;
import com.farminserver.db.finishing_temperature_sensor.Finishing_TemperatureSensorRepository;
import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.converter.Finishing_TemperatureConverter;
import com.farminserver.api.util.Finishing_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Finishing_TemperatureService {

    private final Finishing_TemperatureSensorRepository repository;
    private final Finishing_TemperatureConverter converter;
    private final Finishing_ExcelExporter excelExporter;

    @Autowired
    public Finishing_TemperatureService(Finishing_TemperatureSensorRepository repository, Finishing_TemperatureConverter converter, Finishing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Finishing_TemperatureResponse getTemperatureData(String finishingBarnRoomNum) {
        Finishing_TemperatureSeneorEntity entity = repository.findById(finishingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Finishing_TemperatureResponse> getAllTemperatureData() {
        List<Finishing_TemperatureSeneorEntity> entities = repository.findAll();
        List<Finishing_TemperatureResponse> responses = new ArrayList<>();
        for (Finishing_TemperatureSeneorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Finishing_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportFinishing_TemperatureData(responses, filePath);
    }
}
