package com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.business;

import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller.model.Piglet_PmResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.service.Piglet_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_PmBusiness {

    private final Piglet_PmService pigletPmService;

    @Autowired
    public Piglet_PmBusiness(Piglet_PmService pmService) {
        this.pigletPmService = pmService;
    }

    public Piglet_PmResponse getPmSensorData(String pigletRoomNum) {
        return pigletPmService.getPmData(pigletRoomNum);
    }

    public List<Piglet_PmResponse> getAllPmData() {
        return pigletPmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        pigletPmService.exportPmDataToExcel(filePath);
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
