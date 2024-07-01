package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.service.Nh3Service;
//import com.farminserver.api.domain.nh3_sensor.converter.Nh3Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Nh3Business {

    private final Nh3Service nh3Service;
    //private final Nh3Converter nh3Converter;

    @Autowired
    public Nh3Business(Nh3Service nh3Service) {
        this.nh3Service = nh3Service;
    }

    public Nh3Response getNh3SensorData() {
        return nh3Service.getLatestNh3Data();
    }

    public List<Nh3Response> getAllNh3Data() {
        return nh3Service.getAllNh3Data();
    }

    public void exportNh3DataToExcel(String filePath) throws IOException {
        nh3Service.exportNh3DataToExcel(filePath);
    }
}
