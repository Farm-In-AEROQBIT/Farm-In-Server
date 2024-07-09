package com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.service;

import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.converter.Reserve_Nh3Converter;
import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller.model.Reserve_Nh3Response;
import com.farminserver.db.reserve_nh3_sensor.Reserve_Nh3SensorEntity;
import com.farminserver.db.reserve_nh3_sensor.Reserve_Nh3SensorRepository;
import com.farminserver.api.util.Reserve_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Reserve_Nh3Service {

    private final Reserve_Nh3SensorRepository repository;
    private final Reserve_Nh3Converter converter;
    private final Reserve_ExcelExporter excelExporter;

    @Autowired
    public Reserve_Nh3Service(Reserve_Nh3SensorRepository repository, Reserve_Nh3Converter converter, Reserve_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Reserve_Nh3Response getNh3Data(String ReserveRoomNum) {
        Reserve_Nh3SensorEntity entity = repository.findById(ReserveRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Reserve_Nh3Response> getAllNh3Data() {
        List<Reserve_Nh3SensorEntity> entities = repository.findAll();
        List<Reserve_Nh3Response> responses = new ArrayList<>();
        for (Reserve_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Reserve_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportReserve_Nh3Data(responses, filePath);
    }
}
