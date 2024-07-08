package com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.business;

import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller.model.Finishing_PmResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.service.Finishing_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Finishing_PmBusiness {

    private final Finishing_PmService finishingPmService;

    @Autowired
    public Finishing_PmBusiness(Finishing_PmService pmService) {
        this.finishingPmService = pmService;
    }

    public Finishing_PmResponse getPmSensorData(String boarsBarnRoomNum) {
        return finishingPmService.getPmData(boarsBarnRoomNum);
    }

    public List<Finishing_PmResponse> getAllPmData() {
        return finishingPmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        finishingPmService.exportPmDataToExcel(filePath);
    }
}
