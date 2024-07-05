package com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.service;

import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model.Finishing_HumidityResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.converter.Finishing_Nh3Converter;
import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller.model.Finishing_Nh3Response;
import com.farminserver.api.util.Finishing_ExcelExporter;
import com.farminserver.db.finishing_humidity_sensor.Finishing_HumiditySensorEntity;
import com.farminserver.db.finishing_nh3_sensor.Finishing_Nh3SensorEntity;
import com.farminserver.db.finishing_nh3_sensor.Finishing_Nh3SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Finishing_Nh3Service {

    private final Finishing_Nh3SensorRepository repository;
    private final Finishing_Nh3Converter converter;
    private final Finishing_ExcelExporter excelExporter;

    @Autowired
    public Finishing_Nh3Service(Finishing_Nh3SensorRepository repository, Finishing_Nh3Converter converter , Finishing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.excelExporter = excelExporter;
    }

    public Finishing_Nh3Response getNh3Data(String finishingBarnRoomNum) {
        Finishing_Nh3SensorEntity entity = repository.findById(finishingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Finishing_Nh3Response> getAllNh3Data() {
        List<Finishing_Nh3SensorEntity> entities = repository.findAll();
        List<Finishing_Nh3Response> responses = new ArrayList<>();
        for (Finishing_Nh3SensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }


    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Finishing_Nh3Response> responses = getAllNh3Data();
        excelExporter.exportFinishing_Nh3Data(responses, filePath);
    }
}
