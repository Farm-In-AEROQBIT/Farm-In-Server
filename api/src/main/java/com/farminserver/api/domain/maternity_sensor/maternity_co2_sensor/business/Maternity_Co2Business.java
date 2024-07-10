package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.business;

import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller.model.Maternity_Co2Response;
import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.service.Maternity_Co2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Maternity_Co2Business {

    private final Maternity_Co2Service maternityCo2Service;

    @Autowired
    public Maternity_Co2Business(Maternity_Co2Service co2Service) {
        this.maternityCo2Service = co2Service;
    }

    public Maternity_Co2Response getCo2SensorData(Long maternityRoomNum) {
        return maternityCo2Service.getCo2Data(maternityRoomNum);
    }

    public List<Maternity_Co2Response> getAllCo2Data() {
        return maternityCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        maternityCo2Service.exportCo2DataToExcel(filePath);
    }
}