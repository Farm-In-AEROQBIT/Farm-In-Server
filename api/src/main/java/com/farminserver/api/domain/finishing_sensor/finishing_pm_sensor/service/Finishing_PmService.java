package com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.service;

import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller.model.Finishing_PmResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.converter.Finishing_PmConverter;
import com.farminserver.api.util.Finishing_ExcelExporter;
import com.farminserver.db.finishing_pm_sensor.Finishing_PmSensorRepository;
import com.farminserver.db.finishing_pm_sensor.Finishing_PmSensorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Finishing_PmService {

    private final Finishing_PmSensorRepository repository;
    private final Finishing_PmConverter converter;
    private final Finishing_ExcelExporter excelExporter;

    @Autowired
    public Finishing_PmService(Finishing_PmSensorRepository repository, Finishing_PmConverter converter, Finishing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Finishing_PmResponse getPmData(String finishingBarnRoomNum) {
        Finishing_PmSensorEntity entity = repository.findById(finishingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Finishing_PmResponse> getAllPmData() {
        List<Finishing_PmSensorEntity> entities = repository.findAll();
        List<Finishing_PmResponse> responses = new ArrayList<>();
        for (Finishing_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Finishing_PmResponse> responses = getAllPmData();
        excelExporter.exportFinishing_PmData(responses, filePath);
    }
}
