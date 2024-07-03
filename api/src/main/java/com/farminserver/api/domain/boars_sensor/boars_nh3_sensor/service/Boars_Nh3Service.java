package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.db.boars_nh3_sensor.Nh3SensorRepository;
import com.farminserver.db.boars_nh3_sensor.Nh3SensorEntity;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_Nh3Service {

    private final ExcelExporter excelExporter;

    @Autowired
    public Boars_Nh3Service(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public Boars_Nh3Response getLatestNh3Data() {
        // 예시로 임의의 값을 반환함
        return new Boars_Nh3Response(25.0, "ppm", System.currentTimeMillis());
    }

    public List<Boars_Nh3Response> getAllNh3Data() {
        // 예시 데이터를 반환
        List<Boars_Nh3Response> responses = new ArrayList<>();
        responses.add(new Boars_Nh3Response(25.0, "ppm", System.currentTimeMillis()));
        responses.add(new Boars_Nh3Response(26.0, "ppm", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Boars_Nh3Response> boarsNh3Respons = getAllNh3Data();
        excelExporter.exportnh3Data(boarsNh3Respons, filePath);
    }
}