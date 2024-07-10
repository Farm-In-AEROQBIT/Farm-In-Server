package com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.service;

import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller.model.Growing_HumidityResponse;
import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.converter.Growing_HumidityConverter;
import com.farminserver.db.growing_humidity_sensor.Growing_HumiditySensorEntity;
import com.farminserver.db.growing_humidity_sensor.Growing_HumiditySensorRepository;
import com.farminserver.api.util.Growing_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Growing_HumidityService {

    private final Growing_HumiditySensorRepository repository;
    private final Growing_HumidityConverter converter;
    private final Growing_ExcelExporter boarsExcelExporter;

    @Autowired
    public Growing_HumidityService(Growing_HumiditySensorRepository repository, Growing_HumidityConverter converter, Growing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.boarsExcelExporter = excelExporter;
    }

    public Growing_HumidityResponse getHumidityData(Long growingBarnRoomNum) {
        Growing_HumiditySensorEntity entity = repository.findById(growingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Growing_HumidityResponse> getAllHumidityData() {
        List<Growing_HumiditySensorEntity> entities = repository.findAll();
        List<Growing_HumidityResponse> responses = new ArrayList<>();
        for (Growing_HumiditySensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    /*public List<Boars_HumidityResponse> getAllHumidityData() {
        List<Boars_HumidityResponse> responses = new ArrayList<>();
        responses.add(new Boars_HumidityResponse(55.0, "%", System.currentTimeMillis()));
        responses.add(new Boars_HumidityResponse(56.0, "%", System.currentTimeMillis() - 10000));
        return responses;
    }*/

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Growing_HumidityResponse> growingHumidityResponses = getAllHumidityData();
        boarsExcelExporter.exportGrowing_humidityData(growingHumidityResponses, filePath);
    }
}
