package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.Boars_Co2Service;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Boars_Co2Business {

    private final Boars_Co2Service co2Service;

    @Autowired
    public Boars_Co2Business(Boars_Co2Service co2Service) {
        this.co2Service = co2Service;
    }

    public Boars_Co2Response getCo2SensorData(String boarsBarnRoomNum) {
        return co2Service.getCo2Data(boarsBarnRoomNum);
    }

    public List<Boars_Co2Response> getAllCo2Data() {
        return co2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        co2Service.exportCo2DataToExcel(filePath);
    }
}