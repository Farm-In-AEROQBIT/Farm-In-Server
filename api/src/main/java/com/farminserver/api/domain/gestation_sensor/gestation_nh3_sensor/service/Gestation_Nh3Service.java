package com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.service;

import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.converter.Gestation_Nh3Converter;
import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller.model.Gestation_Nh3Response;
import com.farminserver.db.gestation_nh3_sensor.Gestation_Nh3SensorRepository;
import com.farminserver.db.gestation_nh3_sensor.Gestation_Nh3SensorEntity;
import com.farminserver.api.util.ExcelExporter.Gestation_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gestation_Nh3Service {

    private final Gestation_Nh3SensorRepository repository;
    private final Gestation_Nh3Converter converter;
    private final Gestation_ExcelExporter excelExporter;

    @Autowired
    public Gestation_Nh3Service(Gestation_Nh3SensorRepository repository, Gestation_Nh3Converter converter, Gestation_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Gestation_Nh3Response getNh3Data(Long gestationRoomNum) {
        Gestation_Nh3SensorEntity entity = repository.findById(gestationRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Gestation_Nh3Response> getAllNh3Data() {
        List<Gestation_Nh3SensorEntity> entities = repository.findAll();
        List<Gestation_Nh3Response> responses = new ArrayList<>();
        for (Gestation_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Gestation_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportGestation_Nh3Data(responses, filePath);
    }
}
