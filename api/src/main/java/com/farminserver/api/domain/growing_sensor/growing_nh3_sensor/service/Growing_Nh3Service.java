package com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.service;

import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.converter.Growing_Nh3Converter;
import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller.model.Growing_Nh3Response;
import com.farminserver.db.growing_nh3_sensor.Growing_Nh3SensorRepository;
import com.farminserver.db.growing_nh3_sensor.Growing_Nh3SensorEntity;
import com.farminserver.api.util.ExcelExporter.Growing_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Growing_Nh3Service {

    private final Growing_Nh3SensorRepository repository;
    private final Growing_Nh3Converter converter;
    private final Growing_ExcelExporter excelExporter;

    @Autowired
    public Growing_Nh3Service(Growing_Nh3SensorRepository repository, Growing_Nh3Converter converter, Growing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Growing_Nh3Response getNh3Data(Long growingBarnRoomNum) {
        Growing_Nh3SensorEntity entity = repository.findById(growingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Growing_Nh3Response> getAllNh3Data() {
        List<Growing_Nh3SensorEntity> entities = repository.findAll();
        List<Growing_Nh3Response> responses = new ArrayList<>();
        for (Growing_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Growing_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportGrowing_Nh3Data(responses, filePath);
    }
}
