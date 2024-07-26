package com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.service;

import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model.Finishing_HumidityResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.converter.Finishing_HumidityConverter;
import com.farminserver.api.util.ExcelExporter.Finishing_ExcelExporter;
import com.farminserver.db.finishing_humidity_sensor.Finishing_HumiditySensorEntity;
import com.farminserver.db.finishing_humidity_sensor.Finishing_HumiditySensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Finishing_HumidityService {

    private final Finishing_HumiditySensorRepository repository;
    private final Finishing_HumidityConverter converter;
    private final Finishing_ExcelExporter finishingExcelExporter;

    @Autowired
    public Finishing_HumidityService(Finishing_HumiditySensorRepository repository, Finishing_HumidityConverter converter, Finishing_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.finishingExcelExporter = excelExporter;
    }

    public Finishing_HumidityResponse getHumidityData(Long finishingBarnRoomNum) {
        Finishing_HumiditySensorEntity entity = repository.findById(finishingBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Finishing_HumidityResponse> getAllHumidityData() {
        List<Finishing_HumiditySensorEntity> entities = repository.findAll();
        List<Finishing_HumidityResponse> responses = new ArrayList<>();
        for (Finishing_HumiditySensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Finishing_HumidityResponse> finishingHumidityRespons = getAllHumidityData();
        finishingExcelExporter.exportFinishing_humidityData(finishingHumidityRespons, filePath);
    }
}
