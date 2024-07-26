package com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.service;

import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller.model.Gestation_PmResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.converter.Gestation_PmConverter;
import com.farminserver.db.gestation_pm_sensor.Gestation_PmSensorRepository;
import com.farminserver.db.gestation_pm_sensor.Gestation_PmSensorEntity;
import com.farminserver.api.util.ExcelExporter.Gestation_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gestation_PmService {

    private final Gestation_PmSensorRepository repository;
    private final Gestation_PmConverter converter;
    private final Gestation_ExcelExporter excelExporter;

    @Autowired
    public Gestation_PmService(Gestation_PmSensorRepository repository, Gestation_PmConverter converter, Gestation_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Gestation_PmResponse getPmData(Long gestationRoomNum) {
        Gestation_PmSensorEntity entity = repository.findById(gestationRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Gestation_PmResponse> getAllPmData() {
        List<Gestation_PmSensorEntity> entities = repository.findAll();
        List<Gestation_PmResponse> responses = new ArrayList<>();
        for (Gestation_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Gestation_PmResponse> responses = getAllPmData();
        excelExporter.exportGestation_PmData(responses, filePath);
    }
}
