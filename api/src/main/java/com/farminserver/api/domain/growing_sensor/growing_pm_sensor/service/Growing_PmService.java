package com.farminserver.api.domain.growing_sensor.growing_pm_sensor.service;

import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.controller.model.Growing_PmResponse;
import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.converter.Growing_PmConverter;
import com.farminserver.db.growing_pm_sensor.Growing_PmSensorEntity;
import com.farminserver.db.growing_pm_sensor.Growing_PmSensorRepository;
import com.farminserver.api.util.ExcelExporter.Growing_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Growing_PmService {

    private final Growing_PmSensorRepository repository;
    private final Growing_PmConverter converter;
    private final Growing_ExcelExporter excelExporter;

    @Autowired
    public Growing_PmService(Growing_PmSensorRepository repository, Growing_PmConverter converter, Growing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Growing_PmResponse getPmData(Long growingRoomNum) {
        Growing_PmSensorEntity entity = repository.findById(growingRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Growing_PmResponse> getAllPmData() {
        List<Growing_PmSensorEntity> entities = repository.findAll();
        List<Growing_PmResponse> responses = new ArrayList<>();
        for (Growing_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Growing_PmResponse> responses = getAllPmData();
        excelExporter.exportGrowing_PmData(responses, filePath);
    }
}
