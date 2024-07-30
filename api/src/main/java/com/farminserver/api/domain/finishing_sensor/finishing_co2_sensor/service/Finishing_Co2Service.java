package com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.service;

import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.converter.Finishing_Co2Converter;
import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller.model.Finishing_Co2Response;
import com.farminserver.api.util.ExcelExporter.Finishing_ExcelExporter;
import com.farminserver.db.finishing_co2_sensor.Finishing_Co2SensorEntity;
import com.farminserver.db.finishing_co2_sensor.Finishing_Co2SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Finishing_Co2Service {

    private final Finishing_Co2SensorRepository repository;
    private final Finishing_Co2Converter converter;
    private final Finishing_ExcelExporter excelExporter;

    @Autowired
    public Finishing_Co2Service(Finishing_Co2SensorRepository repository, Finishing_Co2Converter converter, Finishing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Finishing_Co2Response getCo2Data(Long finishingBarnRoomNum) {
        Finishing_Co2SensorEntity entity = repository.findById(finishingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Finishing_Co2Response> getAllCo2Data() {
        List<Finishing_Co2SensorEntity> entities = repository.findAll();
        List<Finishing_Co2Response> responses = new ArrayList<>();
        for (Finishing_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Finishing_Co2Response> responses = getAllCo2Data();
        excelExporter.exportFinishing_co2Data(responses, filePath);
    }
}
