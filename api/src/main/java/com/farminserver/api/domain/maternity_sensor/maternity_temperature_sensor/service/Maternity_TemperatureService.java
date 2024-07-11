package com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.controller.model.Maternity_TemperatureResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.converter.Maternity_TemperatureConverter;
import com.farminserver.api.util.Maternity_ExcelExporter;
import com.farminserver.db.maternity_temperature_sensor.Maternity_TemperatureSensorEntity;
import com.farminserver.db.maternity_temperature_sensor.Maternity_TemperatureSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Maternity_TemperatureService {

    private final Maternity_TemperatureSensorRepository repository;
    private final Maternity_TemperatureConverter converter;
    private final Maternity_ExcelExporter excelExporter;

    @Autowired
    public Maternity_TemperatureService(Maternity_TemperatureSensorRepository repository, Maternity_TemperatureConverter converter, Maternity_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Maternity_TemperatureResponse getTemperatureData(Long maternityRoomNum) {
        Maternity_TemperatureSensorEntity entity = repository.findById(maternityRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Maternity_TemperatureResponse> getAllTemperatureData() {
        List<Maternity_TemperatureSensorEntity> entities = repository.findAll();
        List<Maternity_TemperatureResponse> responses = new ArrayList<>();
        for (Maternity_TemperatureSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Maternity_TemperatureResponse> responses = getAllTemperatureData();
        excelExporter.exportMaternity_TemperatureData(responses, filePath);
    }
}
