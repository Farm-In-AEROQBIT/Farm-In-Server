package com.farminserver.api.domain.pm_sensor.service;

import com.farminserver.api.domain.pm_sensor.controller.model.PmResponse;
import com.farminserver.db.pm_sensor.PmSensorRepository;
import com.farminserver.db.pm_sensor.PmSensorEntity;
import com.farminserver.api.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PmService {

    private final ExcelExporter excelExporter;

    @Autowired
    public PmService(ExcelExporter excelExporter) {
        this.excelExporter = excelExporter;
    }

    public PmResponse getLatestPmData(){
        //예시로 임의의 값을 반환함
        return new PmResponse(12.3, 35.7,42.1,90.1, "㎛", System.currentTimeMillis());
    }

    //public double getPm1_0() {
        //예시 데이터 반환
        //return 12.3;
    //}

    //public double getPm2_5() {
        //예시 데이터 반환
        //return 35.7;
    //}

    //public double getPm10() {
        //예시 데이터 반환
        //return 42.1;
    //}

    //public double getTotalPm() {
        //예시 데이터 반환
        //return 90.1;
    //}

    public List<PmResponse> getAllPmData() {
        //예시 데이터 반환
        List<PmResponse> responses = new ArrayList<>();
        responses.add(new PmResponse(12.3, 35.7,42.1,90.1, "㎛", System.currentTimeMillis()));
        responses.add(new PmResponse(13.3, 36.7,43.1,91.1, "㎛", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<PmResponse> pmResponses = getAllPmData();
        excelExporter.exportPmData(pmResponses, filePath);
    }
}
