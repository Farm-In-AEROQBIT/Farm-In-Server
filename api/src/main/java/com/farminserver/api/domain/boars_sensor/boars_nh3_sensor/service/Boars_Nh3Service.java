package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.converter.Boars_Nh3Converter;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.db.boars_nh3_sensor.Boars_Nh3SensorRepository;
import com.farminserver.db.boars_nh3_sensor.Boars_Nh3SensorEntity;
import com.farminserver.api.util.ExcelExporter.Boars_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_Nh3Service {

    private final Boars_Nh3SensorRepository repository;
    private final Boars_Nh3Converter converter;
    private final Boars_ExcelExporter excelExporter;

    @Autowired
    public Boars_Nh3Service(Boars_Nh3SensorRepository repository, Boars_Nh3Converter converter, Boars_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Boars_Nh3Response getNh3Data(Long boarsBarnRoomNum) {
        Boars_Nh3SensorEntity entity = repository.findById(boarsBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Boars_Nh3Response> getAllNh3Data() {
        List<Boars_Nh3SensorEntity> entities = repository.findAll();
        List<Boars_Nh3Response> responses = new ArrayList<>();
        for (Boars_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Boars_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportBoars_Nh3Data(responses, filePath);
    }
}