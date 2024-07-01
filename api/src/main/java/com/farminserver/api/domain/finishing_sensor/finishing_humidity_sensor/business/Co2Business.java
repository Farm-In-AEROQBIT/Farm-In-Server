package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.Co2Service;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Co2Business {

    private final Co2Service co2Service;

    @Autowired
    public Co2Business(Co2Service co2Service) {
        this.co2Service = co2Service;
    }

    public Co2Response getCo2SensorData() {
        double co2Data = co2Service.getCo2Data();
        return new Co2Response(co2Data, "ppm", System.currentTimeMillis());
    }

    public List<Co2Response> getAllCo2Data() {
        return co2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        co2Service.exportCo2DataToExcel(filePath);
    }
}
