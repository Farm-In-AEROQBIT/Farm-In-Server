package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.service.Boars_Nh3Service;
//import com.farminserver.api.domain.nh3_sensor.converter.Nh3Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Boars_Nh3Business {

    private final Boars_Nh3Service boarsNh3Service;
    //private final Nh3Converter nh3Converter;

    @Autowired
    public Boars_Nh3Business(Boars_Nh3Service boarsNh3Service) {
        this.boarsNh3Service = boarsNh3Service;
    }

    public Boars_Nh3Response getNh3SensorData() {
        return boarsNh3Service.getLatestNh3Data();
    }

    public List<Boars_Nh3Response> getAllNh3Data() {
        return boarsNh3Service.getAllNh3Data();
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        boarsNh3Service.exportNh3DataToExcel(filePath);
    }
}
