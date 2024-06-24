package com.farminserver.api.domain.temperature_sensor.service;

import com.farminserver.api.domain.temperature_sensor.controller.model.TemperatureResponse;
import com.farminserver.db.temperature_sensor.TemperatureRepository;
import com.farminserver.db.temperature_sensor.TemperatureEntity;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {

    private final ExcelExporter excelExporter;

    @Autowired
    public TemperatureService(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public double getTemperatureData() {
        //예시 데이터 반환
        return 22.5;
    }

    public List<TemperatureResponse> getAllTemperatureData() {
        //예시 데이터 반환
        List<TemperatureResponse> responses = new ArrayList<>();
        responses.add(new TemperatureResponse(22.5, "°C", System.currentTimeMillis()));
        responses.add(new TemperatureResponse(23.0, "°C", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<TemperatureResponse> temperatureResponses = getAllTemperatureData();
        excelExporter.exportTemperatureData(temperatureResponses, filePath);
    }
}
