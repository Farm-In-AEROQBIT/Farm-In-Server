package com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.service;


import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.controller.model.Reserve_Co2Response;
import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.converter.Reserve_Co2Converter;
import com.farminserver.api.util.Reserve_ExcelExporter;
import com.farminserver.db.reserve_co2_sensor.Reserve_Co2SensorEntity;
import com.farminserver.db.reserve_co2_sensor.Reserve_Co2SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Reserve_Co2Service {

    private final Reserve_Co2SensorRepository repository;
    private final Reserve_Co2Converter converter;
    private final Reserve_ExcelExporter excelExporter;

    @Autowired
    public Reserve_Co2Service(Reserve_Co2SensorRepository repository, Reserve_Co2Converter converter, Reserve_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Reserve_Co2Response getCo2Data(String reserveSowsRoomNum) {
        Reserve_Co2SensorEntity entity = repository.findById(reserveSowsRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Reserve_Co2Response> getAllCo2Data() {
        List<Reserve_Co2SensorEntity> entities = repository.findAll();
        List<Reserve_Co2Response> responses = new ArrayList<>();
        for (Reserve_Co2SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Reserve_Co2Response> responses = getAllCo2Data();
        excelExporter.exportReserve_co2Data(responses, filePath);
    }
}
