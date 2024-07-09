package com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.business;

import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.controller.model.Maternity_TemperatureResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.service.Maternity_TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Maternity_TemperatureBusiness {

    private final Maternity_TemperatureService maternityTemperatureService;

    @Autowired
    public Maternity_TemperatureBusiness(Maternity_TemperatureService maternityTemperatureService) {
        this.maternityTemperatureService = maternityTemperatureService;
    }

    public Maternity_TemperatureResponse getTemperatureSensorData(String maternityRoomNum) {
        return maternityTemperatureService.getTemperatureData(maternityRoomNum);
    }

    public List<Maternity_TemperatureResponse> getAllTemperatureData() {
        return maternityTemperatureService.getAllTemperatureData();
    }

    public void exportTemperatureDataToExcel(String filePath) throws IOException {
        maternityTemperatureService.exportTemperatureDataToExcel(filePath);
    }
}
