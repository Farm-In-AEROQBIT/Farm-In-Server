package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boar_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.converter.Boars_Co2Converter;
import com.farminserver.api.util.Boars_ExcelExporter;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorEntity;
import com.farminserver.db.boars_co2_sensor.Boars_Co2SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farminserver.db.boars_co2_sensor.CO2SensorRepository;
import com.farminserver.db.boars_co2_sensor.CO2SensorEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Piglet_Co2Service {

    private final Boars_Co2SensorRepository repository;
    private final Boars_Co2Converter converter;
    private final Boars_ExcelExporter excelExporter;

    @Autowired
    public Boars_Co2Service(Boars_Co2SensorRepository repository, Boars_Co2Converter converter, Boars_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Boar_Co2Response getCo2Data(String boarsBarnRoomNum) {
        Boars_Co2SensorEntity entity = repository.findById(boarsBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Boar_Co2Response> getAllCo2Data() {
        List<Boars_Co2SensorEntity> entities = repository.findAll();
        List<Boar_Co2Response> responses = new ArrayList<>();
        for (Boars_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Boar_Co2Response> responses = getAllCo2Data();
        excelExporter.exportBoars_co2Data(responses, filePath);
    }
}
