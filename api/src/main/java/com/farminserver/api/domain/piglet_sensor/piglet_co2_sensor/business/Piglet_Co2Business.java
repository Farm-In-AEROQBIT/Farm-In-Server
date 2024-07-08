package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boar_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.Boars_Co2Service;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.UserService;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_Co2Business {

    private final Boars_Co2Service boarsCo2Service;

    @Autowired
    public Boars_Co2Business(Boars_Co2Service co2Service) {
        this.boarsCo2Service = co2Service;
    }

    public Boar_Co2Response getCo2SensorData(String boarsBarnRoomNum) {
        return boarsCo2Service.getCo2Data(boarsBarnRoomNum);
    }

    public List<Boar_Co2Response> getAllCo2Data() {
        return boarsCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        boarsCo2Service.exportCo2DataToExcel(filePath);
    }
}