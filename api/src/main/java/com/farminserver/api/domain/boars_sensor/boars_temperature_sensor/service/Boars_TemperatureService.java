package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.db.boars_temperature_sensor.TemperatureRepository;
import com.farminserver.db.boars_temperature_sensor.TemperatureEntity;
import com.farminserver.api.util.Boars_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_TemperatureService {

    private final Boars_ExcelExporter boarsExcelExporter;

    @Autowired
    public Boars_TemperatureService(Boars_ExcelExporter boarsExcelExporter) {
        this.boarsExcelExporter = boarsExcelExporter;
    }

    public double getTemperatureData() {
        //예시 데이터 반환
        return 22.5;
    }

    public List<Boars_TemperatureResponse> getAllTemperatureData() {
        //예시 데이터 반환
        List<Boars_TemperatureResponse> responses = new ArrayList<>();
        responses.add(new Boars_TemperatureResponse(22.5, "°C", System.currentTimeMillis()));
        responses.add(new Boars_TemperatureResponse(23.0, "°C", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        List<Boars_TemperatureResponse> boarsTemperatureRespons = getAllTemperatureData();
        boarsExcelExporter.exportTemperatureData(boarsTemperatureRespons, filePath);
    }
}
