package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.service.Boars_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Boars_PmBusiness {

    private final Boars_PmService boarsPmService;

    @Autowired
    public Boars_PmBusiness(Boars_PmService pmService) {
        this.boarsPmService = pmService;
    }

    public Boars_PmResponse getPmSensorData(Long boarsBarnRoomNum) {
        return boarsPmService.getPmData(boarsBarnRoomNum);
    }

    public List<Boars_PmResponse> getAllPmData() {
        return boarsPmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        boarsPmService.exportPmDataToExcel(filePath);
    }

    //public PmResponse getPmSensorData() {
        //double pm1_0 = pmService.getPm1_0();
        //double pm2_5 = pmService.getPm2_5();
        //double pm10 = pmService.getPm10();
        //double totalPm = pmService.getTotalPm();
        //String unit = pmService.getUnit();
        //return pmConverter.convert(pm1_0, pm2_5, pm10, unit, totalPm);
    //}
}
