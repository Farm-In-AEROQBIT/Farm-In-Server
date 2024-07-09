package com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.business;

import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.controller.model.Reserve_PmResponse;
import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.service.Reserve_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Reserve_PmBusiness {

    private final Reserve_PmService reservePmService;

    @Autowired
    public Reserve_PmBusiness(Reserve_PmService pmService) {
        this.reservePmService = pmService;
    }

    public Reserve_PmResponse getPmSensorData(String reserveSowsRoomNum) {
        return reservePmService.getPmData(reserveSowsRoomNum);
    }

    public List<Reserve_PmResponse> getAllPmData() {
        return reservePmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        reservePmService.exportPmDataToExcel(filePath);
    }
}
