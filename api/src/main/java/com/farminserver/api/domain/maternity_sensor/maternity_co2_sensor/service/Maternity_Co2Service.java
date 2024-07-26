package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.service;

import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.converter.Maternity_Co2Converter;
import com.farminserver.api.util.ExcelExporter.Maternity_ExcelExporter;
import com.farminserver.db.maternity_co2_sensor.Maternity_Co2SensorRepository;
import com.farminserver.db.maternity_co2_sensor.Maternity_Co2SensorEntity;
import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller.model.Maternity_Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Maternity_Co2Service {

    private final Maternity_Co2SensorRepository repository;
    private final Maternity_Co2Converter converter;
    private final Maternity_ExcelExporter excelExporter;

    @Autowired
    public Maternity_Co2Service(Maternity_Co2SensorRepository repository, Maternity_Co2Converter converter, Maternity_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Maternity_Co2Response getCo2Data(Long maternityRoomNum) {
        Maternity_Co2SensorEntity entity = repository.findById(maternityRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Maternity_Co2Response> getAllCo2Data() {
        List<Maternity_Co2SensorEntity> entities = repository.findAll();
        List<Maternity_Co2Response> responses = new ArrayList<>();
        for (Maternity_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Maternity_Co2Response> responses = getAllCo2Data();
        excelExporter.exportMaternity_co2Data(responses, filePath);
    }
}
