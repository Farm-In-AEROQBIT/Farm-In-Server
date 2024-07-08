package com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.business;

import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.controller.model.Maternity_PmResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.service.Maternity_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Maternity_PmBusiness {

    private final Maternity_PmService maternityPmService;

    @Autowired
    public Maternity_PmBusiness(Maternity_PmService pmService) {
        this.maternityPmService = pmService;
    }

    public Maternity_PmResponse getPmSensorData(String maternityRoomNum) {
        return maternityPmService.getPmData(maternityRoomNum);
    }

    public List<Maternity_PmResponse> getAllPmData() {
        return maternityPmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        maternityPmService.exportPmDataToExcel(filePath);
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