package com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.service;

import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.controller.model.Reserve_PmResponse;
import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.converter.Reserve_PmConverter;
import com.farminserver.db.reserve_pm_sensor.Reserve_PmSensorRepository;
import com.farminserver.db.reserve_pm_sensor.Reserve_PmSensorEntity;
import com.farminserver.api.util.ExcelExporter.Reserve_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Reserve_PmService {

    private final Reserve_PmSensorRepository repository;
    private final Reserve_PmConverter converter;
    private final Reserve_ExcelExporter excelExporter;

    @Autowired
    public Reserve_PmService(Reserve_PmSensorRepository repository, Reserve_PmConverter converter, Reserve_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Reserve_PmResponse getPmData(Long reserveSowsRoomNum) {
        Reserve_PmSensorEntity entity = repository.findById(reserveSowsRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Reserve_PmResponse> getAllPmData() {
        List<Reserve_PmSensorEntity> entities = repository.findAll();
        List<Reserve_PmResponse> responses = new ArrayList<>();
        for (Reserve_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Reserve_PmResponse> responses = getAllPmData();
        excelExporter.exportReserve_PmData(responses, filePath);
    }
}
