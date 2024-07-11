package com.farminserver.api.domain.growing_sensor.growing_co2_sensor.service;

import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller.model.Growing_Co2Response;
import com.farminserver.db.growing_co2_sensor.Growing_Co2SensorEntity;
import com.farminserver.db.growing_co2_sensor.Growing_Co2SensorRepository;
import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.converter.Growing_Co2Converter;
import com.farminserver.api.util.Growing_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Growing_Co2Service {

    private final Growing_Co2SensorRepository repository;
    private final Growing_Co2Converter converter;
    private final Growing_ExcelExporter excelExporter;

    @Autowired
    public Growing_Co2Service(Growing_Co2SensorRepository repository, Growing_Co2Converter converter, Growing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Growing_Co2Response getCo2Data(Long growingBarnRoomNum) {
        Growing_Co2SensorEntity entity = repository.findById(growingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Growing_Co2Response> getAllCo2Data() {
        List<Growing_Co2SensorEntity> entities = repository.findAll();
        List<Growing_Co2Response> responses = new ArrayList<>();
        for (Growing_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Growing_Co2Response> responses = getAllCo2Data();
        excelExporter.exportGrowing_co2Data(responses, filePath);
    }
}
