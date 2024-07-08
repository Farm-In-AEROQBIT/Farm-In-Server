package com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.business;

import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller.model.Gestation_Co2Response;
import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.service.Gestation_Co2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Gestation_Co2Business {

    private final Gestation_Co2Service gestationCo2Service;

    @Autowired
    public Gestation_Co2Business(Gestation_Co2Service co2Service){
        this.gestationCo2Service = co2Service;
    }

    public Gestation_Co2Response getCo2SensorData(String gestationBarnRoomNum) {
        return gestationCo2Service.getCo2Data(gestationBarnRoomNum);
    }

    public List<Gestation_Co2Response> getAllCo2Data() {
        return gestationCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        gestationCo2Service.exportCo2DataToExcel(filePath);
    }
}
