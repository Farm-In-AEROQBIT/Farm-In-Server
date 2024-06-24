package com.farminserver.api.domain.co2_sensor.service;

import com.farminserver.api.domain.co2_sensor.controller.model.Co2Response;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farminserver.db.co2_sensor.CO2SensorRepository;
import com.farminserver.db.co2_sensor.CO2SensorEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Co2Service {

    private final ExcelExporter excelExporter;

    @Autowired
    public Co2Service(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public double getCo2Data() {
        return 400.0; // 실제 센서 데이터 가져오기 로직 (임의의 값 반환)
    }

    public List<Co2Response> getAllCo2Data() {
        // 예시 데이터를 반환
        List<Co2Response> responses = new ArrayList<>();
        responses.add(new Co2Response(400.0, "ppm", System.currentTimeMillis()));
        responses.add(new Co2Response(401.0, "ppm", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<Co2Response> co2Responses = getAllCo2Data();
        excelExporter.exportco2Data(co2Responses, filePath);
    }
}
