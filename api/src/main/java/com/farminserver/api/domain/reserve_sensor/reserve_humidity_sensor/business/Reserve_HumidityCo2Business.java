package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.business;

import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.controller.model.Reserve_Co2Response;
import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.service.Reserve_Co2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Reserve_HumidityCo2Business {

    private final Reserve_Co2Service reserveCo2Service;

    @Autowired
    public Reserve_Co2Business(Reserve_Co2Service co2Service) {
        this.reserveCo2Service = co2Service;
    }

    public Reserve_Co2Response getCo2SensorData(String reserveBarnRoomNum) {
        return reserveCo2Service.getCo2Data(reserveBarnRoomNum);
    }

    public List<Reserve_Co2Response> getAllCo2Data() {
        return reserveCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        reserveCo2Service.exportCo2DataToExcel(filePath);
    }
}