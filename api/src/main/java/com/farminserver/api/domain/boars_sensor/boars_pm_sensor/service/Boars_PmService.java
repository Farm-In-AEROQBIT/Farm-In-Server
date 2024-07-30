package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.converter.Boars_PmConverter;
import com.farminserver.db.boars_pm_sensor.Boars_PmSensorRepository;
import com.farminserver.db.boars_pm_sensor.Boars_PmSensorEntity;
import com.farminserver.api.util.ExcelExporter.Boars_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_PmService {

    private final Boars_PmSensorRepository repository;
    private final Boars_PmConverter converter;
    private final Boars_ExcelExporter excelExporter;

    @Autowired
    public Boars_PmService(Boars_PmSensorRepository repository, Boars_PmConverter converter, Boars_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Boars_PmResponse getPmData(Long boarsBarnRoomNum) {
        Boars_PmSensorEntity entity = repository.findById(boarsBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Boars_PmResponse> getAllPmData() {
        List<Boars_PmSensorEntity> entities = repository.findAll();
        List<Boars_PmResponse> responses = new ArrayList<>();
        for (Boars_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Boars_PmResponse> responses = getAllPmData();
        excelExporter.exportBoars_PmData(responses, filePath);
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
