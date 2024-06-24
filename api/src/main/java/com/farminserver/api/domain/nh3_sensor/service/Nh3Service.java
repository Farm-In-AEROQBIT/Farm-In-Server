package com.farminserver.api.domain.nh3_sensor.service;

import com.farminserver.api.domain.nh3_sensor.controller.model.Nh3Response;
import com.farminserver.db.nh3_sensor.Nh3SensorRepository;
import com.farminserver.db.nh3_sensor.Nh3SensorEntity;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Nh3Service {

    private final ExcelExporter excelExporter;

    @Autowired
    public Nh3Service(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public Nh3Response getLatestNh3Data() {
        // 예시로 임의의 값을 반환함
        return new Nh3Response(25.0, "ppm", System.currentTimeMillis());
    }

    public List<Nh3Response> getAllNh3Data() {
        // 예시 데이터를 반환
        List<Nh3Response> responses = new ArrayList<>();
        responses.add(new Nh3Response(25.0, "ppm", System.currentTimeMillis()));
        responses.add(new Nh3Response(26.0, "ppm", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        List<Nh3Response> nh3Responses = getAllNh3Data();
        excelExporter.exportnh3Data(nh3Responses, filePath);
    }
}