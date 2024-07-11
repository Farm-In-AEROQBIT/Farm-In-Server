package com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.business;

import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.controller.model.Maternity_HumidityResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.service.Maternity_HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Maternity_HumidityBusiness {

    private final Maternity_HumidityService maternityHumidityService;

    @Autowired
    public Maternity_HumidityBusiness(Maternity_HumidityService humidityService) {
        this.maternityHumidityService = humidityService;
    }

    public Maternity_HumidityResponse getHumiditySensorData(Long maternityRoomNum) {
        return maternityHumidityService.getHumidityData(maternityRoomNum);
    }

    public List<Maternity_HumidityResponse> getAllHumidityData() {
        return maternityHumidityService.getAllHumidityData();
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        maternityHumidityService.exportHumidityDataToExcel(filePath);
    }
}
