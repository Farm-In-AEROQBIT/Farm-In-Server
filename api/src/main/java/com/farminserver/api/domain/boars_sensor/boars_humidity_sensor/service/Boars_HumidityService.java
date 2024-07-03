package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.Boars_HumidityResponse;
import com.farminserver.api.util.Boars_ExcelExporter;
import com.farminserver.db.boars_humidity_sensor.HumiditySensorEntity;
import com.farminserver.db.boars_humidity_sensor.HumiditySensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_HumidityService {

    private final Boars_ExcelExporter boarsExcelExporter;

    @Autowired
    public Boars_HumidityService(Boars_ExcelExporter boarsExcelExporter) {
        this.boarsExcelExporter = boarsExcelExporter;
    }

    public double getHumidityData() {
        return 55.0;
    }

    public List<Boars_HumidityResponse> getAllHumidityData() {
        List<Boars_HumidityResponse> responses = new ArrayList<>();
        responses.add(new Boars_HumidityResponse(55.0, "%", System.currentTimeMillis()));
        responses.add(new Boars_HumidityResponse(56.0, "%", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Boars_HumidityResponse> boarsHumidityRespons = getAllHumidityData();
        boarsExcelExporter.exporthumidityData(boarsHumidityRespons, filePath);
    }
}
