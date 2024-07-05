package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.business;

import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.service.Martenity_Co2Service;
import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller.model.Martenity_Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Martenity_Co2Business {

    private final Martenity_Co2Service martenityCo2Service;

    @Autowired
    public Martenity_Co2Business(Martenity_Co2Service co2Service) {
        this.martenityCo2Service = co2Service;
    }

    public Martenity_Co2Response getCo2SensorData(String maternityRoomNum) {
        return martenityCo2Service.getCo2Data(maternityRoomNum);
    }

    public List<Martenity_Co2Response> getAllCo2Data() {
        return martenityCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        martenityCo2Service.exportCo2DataToExcel(filePath);
    }
}