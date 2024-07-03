package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.converter.Boars_PmConverter;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.service.Boars_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Boars_PmBusiness {

    private final Boars_PmService boarsPmService;
    //private final PmConverter pmConverter;

    @Autowired
    public Boars_PmBusiness(Boars_PmService boarsPmService, Boars_PmConverter boarsPmConverter) {
        this.boarsPmService = boarsPmService;
        //this.pmConverter = pmConverter;
    }

    public Boars_PmResponse getPmSensorData(){
        return boarsPmService.getLatestPmData();
    }

    public List<Boars_PmResponse> getAllPmData(){
        return boarsPmService.getAllPmData();
    }

    //public PmResponse getPmSensorData(){
        //double pmData = pmService.getPm1_0();
        //double pmData = pmService.getPm2_5();
        //double pmData = pmService.getPm10();
        //return new PmResponse(pmData, "㎛", System.currentTimeMillis());
    //}

    public void exportPmDataToExcel(String filePath) throws IOException{
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
