package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.Boars_Co2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Martenity_Co2Business {

    private final Boars_Co2Service maternityCo2Service;

    @Autowired
    public Martenity_Co2Business(Boars_Co2Service co2Service) {
        this.maternityCo2Service = co2Service;
    }

    public Boars_Co2Response getCo2SensorData(String maternityRoomNum) {
        return maternityCo2Service.getCo2Data(maternityRoomNum);
    }

    public List<Boars_Co2Response> getAllCo2Data() {
        return maternityCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        maternityCo2Service.exportCo2DataToExcel(filePath);
    }
}