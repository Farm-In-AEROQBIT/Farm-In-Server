package com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.business;

import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.service.Gestation_Nh3Service;
import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller.model.Gestation_Nh3Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Gestation_Nh3Business {

    private final Gestation_Nh3Service gestationNh3Service;

    @Autowired
    public Gestation_Nh3Business(Gestation_Nh3Service nh3Service) {
        this.gestationNh3Service = nh3Service;
    }

    public Gestation_Nh3Response getNh3SensorData(String boarsBarnRoomNum) {
        return gestationNh3Service.getNh3Data(boarsBarnRoomNum);
    }

    public List<Gestation_Nh3Response> getAllNh3Data() {
        return gestationNh3Service.getAllNh3Data();
    }

    public void exportGestation_Nh3DataToExcel(String filePath) throws IOException {
        gestationNh3Service.exportNh3DataToExcel(filePath);
    }
}
