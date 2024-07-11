package com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.service;

import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller.model.Piglet_Nh3Response;
import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.converter.Piglet_Nh3Converter;
import com.farminserver.api.util.Piglet_ExcelExporter;
import com.farminserver.db.piglet_nh3_sensor.Piglet_Nh3SensorEntity;
import com.farminserver.db.piglet_nh3_sensor.Piglet_Nh3SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Piglet_Nh3Service {

    private final Piglet_Nh3SensorRepository repository;
    private final Piglet_Nh3Converter converter;
    private final Piglet_ExcelExporter excelExporter;

    @Autowired
    public Piglet_Nh3Service(Piglet_Nh3SensorRepository repository, Piglet_Nh3Converter converter, Piglet_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Piglet_Nh3Response getNh3Data(Long pigletRoomNum) {
        Piglet_Nh3SensorEntity entity = repository.findById(pigletRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Piglet_Nh3Response> getAllNh3Data() {
        List<Piglet_Nh3SensorEntity> entities = repository.findAll();
        List<Piglet_Nh3Response> responses = new ArrayList<>();
        for (Piglet_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Piglet_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportPiglet_Nh3Data(responses, filePath);
    }
}