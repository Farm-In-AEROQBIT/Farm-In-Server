package com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.business;


import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller.model.Piglet_Nh3Response;
import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.service.Piglet_Nh3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_Nh3Business {

    private final Piglet_Nh3Service pigletNh3Service;

    @Autowired
    public Piglet_Nh3Business(Piglet_Nh3Service nh3Service) {
        this.pigletNh3Service = nh3Service;
    }

    public Piglet_Nh3Response getNh3SensorData(String pigletRoomNum) {
        return pigletNh3Service.getNh3Data(pigletRoomNum);
    }

    public List<Piglet_Nh3Response> getAllCo2Data() {
        return pigletNh3Service.getAllNh3Data();
    }

    public void exportPiglet_Nh3DataToExcel(String filePath) throws IOException {
        pigletNh3Service.exportCo2DataToExcel(filePath);
    }
}
