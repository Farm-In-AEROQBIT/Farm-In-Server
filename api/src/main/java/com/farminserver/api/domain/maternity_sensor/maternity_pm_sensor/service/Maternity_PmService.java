package com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.service;

import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.controller.model.Maternity_PmResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.converter.Maternity_PmConverter;
import com.farminserver.api.util.Maternity_ExcelExporter;
import com.farminserver.db.maternity_pm_sensor.Maternity_PmSensorEntity;
import com.farminserver.db.maternity_pm_sensor.Maternity_PmSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Maternity_PmService {

    private final Maternity_PmSensorRepository repository;
    private final Maternity_PmConverter converter;
    private final Maternity_ExcelExporter excelExporter;

    @Autowired
    public Maternity_PmService(Maternity_PmSensorRepository repository, Maternity_PmConverter converter, Maternity_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Maternity_PmResponse getPmData(Long MaternityRoomNum) {
        Maternity_PmSensorEntity entity = repository.findById(MaternityRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Maternity_PmResponse> getAllPmData() {
        List<Maternity_PmSensorEntity> entities = repository.findAll();
        List<Maternity_PmResponse> responses = new ArrayList<>();
        for (Maternity_PmSensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Maternity_PmResponse> responses = getAllPmData();
        excelExporter.exportMaternity_PmData(responses, filePath);
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

