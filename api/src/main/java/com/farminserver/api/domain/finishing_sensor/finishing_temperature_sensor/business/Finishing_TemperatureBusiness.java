package com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.business;

import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller.model.Finishing_TemperatureResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.service.Finishing_TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Finishing_TemperatureBusiness {

    private final Finishing_TemperatureService finishingTemperatureService;

    @Autowired
    public Finishing_TemperatureBusiness(Finishing_TemperatureService finishingTemperatureService) {
        this.finishingTemperatureService = finishingTemperatureService;
    }

    public Finishing_TemperatureResponse getTemperatureSensorData(Long finishingBarnRoomNum) {
        return finishingTemperatureService.getTemperatureData(finishingBarnRoomNum);
    }

    public List<Finishing_TemperatureResponse> getAllTemperatureData() {
        return finishingTemperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        finishingTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
