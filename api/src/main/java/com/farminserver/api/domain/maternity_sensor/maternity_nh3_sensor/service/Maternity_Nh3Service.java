package com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.service;

import com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.converter.Maternity_Nh3Converter;
import com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.controller.model.Maternity_Nh3Response;
import com.farminserver.api.util.ExcelExporter.Maternity_ExcelExporter;

import com.farminserver.db.maternity_nh3_sensor.Maternity_Nh3SensorEntity;
import com.farminserver.db.maternity_nh3_sensor.Maternity_Nh3SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Maternity_Nh3Service {


    private final Maternity_Nh3SensorRepository repository;
    private final Maternity_Nh3Converter converter;
    private final Maternity_ExcelExporter excelExporter;

    @Autowired
    public Maternity_Nh3Service(Maternity_Nh3SensorRepository repository, Maternity_Nh3Converter converter, Maternity_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Maternity_Nh3Response getNh3Data(Long maternityRoomNum) {
        Maternity_Nh3SensorEntity entity = repository.findById(maternityRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Maternity_Nh3Response> getAllNh3Data() {
        List<Maternity_Nh3SensorEntity> entities = repository.findAll();
        List<Maternity_Nh3Response> responses = new ArrayList<>();
        for (Maternity_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Maternity_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportMaternity_Nh3Data(responses, filePath);
    }
}
