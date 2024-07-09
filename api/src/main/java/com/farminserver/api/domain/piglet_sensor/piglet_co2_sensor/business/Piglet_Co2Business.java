package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.business;

import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller.model.Piglet_Co2Response;
import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.service.Piglet_Co2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_Co2Business {

    private final Piglet_Co2Service pigletCo2Service;

    @Autowired
    public Piglet_Co2Business(Piglet_Co2Service co2Service) {
        this.pigletCo2Service = co2Service;
    }

    public Piglet_Co2Response getCo2SensorData(String pigletRoomNum) {
        return pigletCo2Service.getCo2Data(pigletRoomNum);
    }

    public List<Piglet_Co2Response> getAllCo2Data() {
        return pigletCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        pigletCo2Service.exportCo2DataToExcel(filePath);
    }
}