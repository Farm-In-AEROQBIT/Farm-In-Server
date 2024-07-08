package com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.UserService;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.service.Boars_Nh3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Maternity_Nh3Business {

    private final Boars_Nh3Service boarsNh3Service;

    @Autowired
    public Boars_Nh3Business(Boars_Nh3Service nh3Service) {
        this.boarsNh3Service = nh3Service;
    }

    public Boars_Nh3Response getNh3SensorData(String boarsBarnRoomNum) {
        return boarsNh3Service.getNh3Data(boarsBarnRoomNum);
    }

    public List<Boars_Nh3Response> getAllCo2Data() {
        return boarsNh3Service.getAllNh3Data();
    }

    public void exportBoars_Nh3DataToExcel(String filePath) throws IOException {
        boarsNh3Service.exportCo2DataToExcel(filePath);
    }
}
