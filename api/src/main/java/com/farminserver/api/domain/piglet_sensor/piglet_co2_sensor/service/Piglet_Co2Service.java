package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.service;

import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller.model.Piglet_Co2Response;
import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.converter.Piglet_Co2Converter;

import com.farminserver.db.piglet_co2_sensor.Piglet_Co2SensorEntity;
import com.farminserver.db.piglet_co2_sensor.Piglet_Co2SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Piglet_Co2Service {

    private final Piglet_Co2SensorRepository repository;
    private final Piglet_Co2Converter converter;
    private final Piglet_ExcelExporter excelExporter;

    @Autowired
    public Piglet_Co2Service(Piglet_Co2SensorRepository repository, Piglet_Co2Converter converter, Piglet_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Piglet_Co2Response getCo2Data(String pigletRoomNum) {
        Piglet_Co2SensorEntity entity = repository.findById(pigletRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Piglet_Co2Response> getAllCo2Data() {
        List<Piglet_Co2SensorEntity> entities = repository.findAll();
        List<Piglet_Co2Response> responses = new ArrayList<>();
        for (Piglet_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Piglet_Co2Response> responses = getAllCo2Data();
        excelExporter.exportPiglet_co2Data(responses, filePath);
    }
}
