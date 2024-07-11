package com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.business;

import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller.model.Gestation_PmResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.service.Gestation_PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Gestation_PmBusiness {

    private final Gestation_PmService gestationPmService;

    @Autowired
    public Gestation_PmBusiness(Gestation_PmService pmService) {
        this.gestationPmService = pmService;
    }

    public Gestation_PmResponse getPmSensorData(Long gestationRoomNum) {
        return gestationPmService.getPmData(gestationRoomNum);
    }

    public List<Gestation_PmResponse> getAllPmData() {
        return gestationPmService.getAllPmData();
    }

    public void exportPmDataToExcel(String filePath) throws IOException {
        gestationPmService.exportPmDataToExcel(filePath);
    }
}
