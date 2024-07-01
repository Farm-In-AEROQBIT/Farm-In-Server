package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.HumidityResponse;
import com.farminserver.api.util.ExcelExporter;
import com.farminserver.db.boars_humidity_sensor.HumiditySensorEntity;
import com.farminserver.db.boars_humidity_sensor.HumiditySensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HumidityService {

    private final ExcelExporter excelExporter;

    @Autowired
    public HumidityService(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public double getHumidityData() {
        return 55.0;
    }

    public List<HumidityResponse> getAllHumidityData() {
        List<HumidityResponse> responses = new ArrayList<>();
        responses.add(new HumidityResponse(55.0, "%", System.currentTimeMillis()));
        responses.add(new HumidityResponse(56.0, "%", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<HumidityResponse> humidityResponses = getAllHumidityData();
        excelExporter.exporthumidityData(humidityResponses, filePath);
    }
}
