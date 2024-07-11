package com.farminserver.api.domain.growing_sensor.growing_pm_sensor.business;

import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.controller.model.Growing_PmResponse;
import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.service.Growing_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Growing_PmBusiness {

    private final Growing_PmService growingPmService;

    @Autowired
    public Growing_PmBusiness(Growing_PmService pmService) {
        this.growingPmService = pmService;
    }

    public Growing_PmResponse getPmSensorData(Long growingRoomNum) {
        return growingPmService.getPmData(growingRoomNum);
    }

    public List<Growing_PmResponse> getAllPmData() {
        return growingPmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        growingPmService.exportPmDataToExcel(filePath);
    }
}
