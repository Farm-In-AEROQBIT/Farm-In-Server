package com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.service;

import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.controller.model.Reserve_TemperatureResponse;
import com.farminserver.db.reserve_temperature_sensor.Reserve_TemperatureSensorEntity;
import com.farminserver.db.reserve_temperature_sensor.Reserve_TemperatureSensorRepository;
import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.converter.Reserve_TemperatureConverter;
import com.farminserver.api.util.Reserve_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Reserve_TemperatureService {

    private final Reserve_TemperatureSensorRepository repository;
    private final Reserve_TemperatureConverter converter;
    private final Reserve_ExcelExporter excelExporter;

    @Autowired
    public Reserve_TemperatureService(Reserve_TemperatureSensorRepository repository, Reserve_TemperatureConverter converter, Reserve_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Reserve_TemperatureResponse getTemperatureData(String reserveSowsRoomNum) {
        Reserve_TemperatureSensorEntity entity = repository.findById(reserveSowsRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Reserve_TemperatureResponse> getAllTemperatureData() {
        List<Reserve_TemperatureSensorEntity> entities = repository.findAll();
        List<Reserve_TemperatureResponse> responses = new ArrayList<>();
        for (Reserve_TemperatureSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Reserve_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportReserve_TemperatureData(responses, filePath);
    }
}
