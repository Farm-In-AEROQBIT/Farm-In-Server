package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorEntity;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorRepository;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.converter.Boars_Co2Converter;
import com.farminserver.api.util.ExcelExporter.Boars_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_Co2Service {

    private final Boars_Co2SensorRepository repository;
    private final Boars_Co2Converter converter;
    private final Boars_ExcelExporter excelExporter;

    @Autowired
    public Boars_Co2Service(Boars_Co2SensorRepository repository, Boars_Co2Converter converter, Boars_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Boars_Co2Response getCo2Data(Long boarsBarnRoomNum) {
        Boars_Co2SensorEntity entity = repository.findById(boarsBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Boars_Co2Response> getAllCo2Data() {
        List<Boars_Co2SensorEntity> entities = repository.findAll();
        List<Boars_Co2Response> responses = new ArrayList<>();
        for (Boars_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Boars_Co2Response> responses = getAllCo2Data();
        excelExporter.exportBoars_co2Data(responses, filePath);
    }
}
