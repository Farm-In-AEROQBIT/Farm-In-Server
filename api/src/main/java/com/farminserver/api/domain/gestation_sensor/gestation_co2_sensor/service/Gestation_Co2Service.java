package com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.service;

import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller.model.Gestation_Co2Response;
import com.farminserver.db.gestation_co2_sensor.Gestation_Co2SensorEntity;
import com.farminserver.db.gestation_co2_sensor.Gestation_Co2SensorRepository;
import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.converter.Gestation_Co2Converter;
import com.farminserver.api.util.Gestation_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gestation_Co2Service {

    private final Gestation_Co2SensorRepository repository;
    private final Gestation_Co2Converter converter;
    private final Gestation_ExcelExporter excelExporter;

    @Autowired
    public Gestation_Co2Service(Gestation_Co2SensorRepository repository, Gestation_Co2Converter converter, Gestation_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Gestation_Co2Response getCo2Data(Long boarsBarnRoomNum) {
        Gestation_Co2SensorEntity entity = repository.findById(boarsBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Gestation_Co2Response> getAllCo2Data() {
        List<Gestation_Co2SensorEntity> entities = repository.findAll();
        List<Gestation_Co2Response> responses = new ArrayList<>();
        for (Gestation_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Gestation_Co2Response> responses = getAllCo2Data();
        excelExporter. exportGestation_co2Data(responses, filePath);
    }
}
