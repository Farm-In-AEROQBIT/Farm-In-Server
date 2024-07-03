package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farminserver.db.boars_co2_sensor.CO2SensorRepository;
import com.farminserver.db.boars_co2_sensor.CO2SensorEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Finishing_Nh3Service {

    private final ExcelExporter excelExporter;

    @Autowired
    public Finishing_Nh3Service(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public double getCo2Data() {
        return 400.0; // 실제 센서 데이터 가져오기 로직 (임의의 값 반환)
    }

    public List<UserResponse> getAllCo2Data() {
        // 예시 데이터를 반환
        List<UserResponse> responses = new ArrayList<>();
        responses.add(new UserResponse(400.0, "ppm", System.currentTimeMillis()));
        responses.add(new UserResponse(401.0, "ppm", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        List<UserResponse> userRespons = getAllCo2Data();
        excelExporter.exportco2Data(userRespons, filePath);
    }
}
