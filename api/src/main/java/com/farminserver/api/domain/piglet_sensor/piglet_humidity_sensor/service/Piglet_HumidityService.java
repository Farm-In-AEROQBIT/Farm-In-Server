package com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.service;

import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller.model.Piglet_HumidityResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.converter.Piglet_HumidityConverter;
import com.farminserver.api.util.Piglet_ExcelExporter;
import com.farminserver.db.piglet_humidity_sensor.Piglet_HumiditySensorEntity;
import com.farminserver.db.piglet_humidity_sensor.Piglet_HumiditySensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Piglet_HumidityService {

    private final Piglet_HumiditySensorRepository repository;
    private final Piglet_HumidityConverter converter;
    private final Piglet_ExcelExporter pigletExcelExporter;

    @Autowired
    public Piglet_HumidityService(Piglet_HumiditySensorRepository repository, Piglet_HumidityConverter converter, Piglet_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.pigletExcelExporter = excelExporter;
    }

    public Piglet_HumidityResponse getHumidityData(Long pigletRoomNum) {
        Piglet_HumiditySensorEntity entity = repository.findById(pigletRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Piglet_HumidityResponse> getAllHumidityData() {
        List<Piglet_HumiditySensorEntity> entities = repository.findAll();
        List<Piglet_HumidityResponse> responses = new ArrayList<>();
        for (Piglet_HumiditySensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    /*public List<BPiglet_HumidityResponse> getAllHumidityData() {
        List<Piglet_HumidityResponse> responses = new ArrayList<>();
        responses.add(new Piglet_HumidityResponse(55.0, "%", System.currentTimeMillis()));
        responses.add(new Piglet_HumidityResponse(56.0, "%", System.currentTimeMillis() - 10000));
        return responses;
    }*/

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Piglet_HumidityResponse> PigletHumidityResponse = getAllHumidityData();
        pigletExcelExporter.exportPiglet_humidityData(PigletHumidityResponse, filePath);
    }
}