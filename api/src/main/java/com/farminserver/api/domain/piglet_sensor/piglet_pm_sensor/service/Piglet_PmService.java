package com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.service;

import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller.model.Piglet_PmResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.converter.Piglet_PmConverter;
import com.farminserver.api.util.Piglet_ExcelExporter;
import com.farminserver.db.piglet_pm_sensor.Piglet_PmSensorEntity;
import com.farminserver.db.piglet_pm_sensor.Piglet_PmSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Piglet_PmService {

    private final Piglet_PmSensorRepository repository;
    private final Piglet_PmConverter converter;
    private final Piglet_ExcelExporter excelExporter;

    @Autowired
    public Piglet_PmService(Piglet_PmSensorRepository repository, Piglet_PmConverter converter, Piglet_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Piglet_PmResponse getPmData(String pigletRoomNum) {
        Piglet_PmSensorEntity entity = repository.findById(pigletRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Piglet_PmResponse> getAllPmData() {
        List<Piglet_PmSensorEntity> entities = repository.findAll();
        List<Piglet_PmResponse> responses = new ArrayList<>();
        for (Piglet_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Piglet_PmResponse> responses = getAllPmData();
        excelExporter.exportPiglet_PmData(responses, filePath);
    }

    //public double getPm1_0() {
    //예시 데이터 반환
    //return 12.3;
    //}

    //public double getPm2_5() {
    //예시 데이터 반환
    //return 35.7;
    //}

    //public double getPm10() {
    //예시 데이터 반환
    //return 42.1;
    //}

    //public double getTotalPm() {
    //예시 데이터 반환
    //return 90.1;
    //}
}
