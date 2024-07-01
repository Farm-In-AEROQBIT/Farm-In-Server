package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.converter.PmConverter;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.service.PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class PmBusiness {

    private final PmService pmService;
    //private final PmConverter pmConverter;

    @Autowired
    public PmBusiness(PmService pmService, PmConverter pmConverter) {
        this.pmService = pmService;
        //this.pmConverter = pmConverter;
    }

    public PmResponse getPmSensorData(){
        return pmService.getLatestPmData();
    }

    public List<PmResponse> getAllPmData(){
        return pmService.getAllPmData();
    }

    //public PmResponse getPmSensorData(){
        //double pmData = pmService.getPm1_0();
        //double pmData = pmService.getPm2_5();
        //double pmData = pmService.getPm10();
        //return new PmResponse(pmData, "㎛", System.currentTimeMillis());
    //}

    public void exportPmDataToExcel(String filePath) throws IOException{
        pmService.exportPmDataToExcel(filePath);
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
