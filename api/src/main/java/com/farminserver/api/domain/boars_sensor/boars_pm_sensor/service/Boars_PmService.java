package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.service;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.db.boars_pm_sensor.PmSensorRepository;
import com.farminserver.db.boars_pm_sensor.PmSensorEntity;
import com.farminserver.api.util.Boars_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Boars_PmService {

    private final Boars_ExcelExporter boarsExcelExporter;

    @Autowired
    public Boars_PmService(Boars_ExcelExporter boarsExcelExporter) {
        this.boarsExcelExporter = boarsExcelExporter;
    }

    public Boars_PmResponse getLatestPmData(){
        //예시로 임의의 값을 반환함
        return new Boars_PmResponse(12.3, 35.7,42.1,90.1, "㎛", System.currentTimeMillis());
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

    public List<Boars_PmResponse> getAllPmData() {
        //예시 데이터 반환
        List<Boars_PmResponse> responses = new ArrayList<>();
        responses.add(new Boars_PmResponse(12.3, 35.7,42.1,90.1, "㎛", System.currentTimeMillis()));
        responses.add(new Boars_PmResponse(13.3, 36.7,43.1,91.1, "㎛", System.currentTimeMillis() - 10000));
        return responses;
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        List<Boars_PmResponse> boarsPmRespons = getAllPmData();
        boarsExcelExporter.exportPmData(boarsPmRespons, filePath);
    }
}
