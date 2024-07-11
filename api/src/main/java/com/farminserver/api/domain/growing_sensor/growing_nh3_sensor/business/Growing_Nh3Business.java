package com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.business;

import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller.model.Growing_Nh3Response;
import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.service.Growing_Nh3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Growing_Nh3Business {

    private final Growing_Nh3Service growingNh3Service;

    @Autowired
    public Growing_Nh3Business(Growing_Nh3Service nh3Service) {
        this.growingNh3Service = nh3Service;
    }

    public Growing_Nh3Response getNh3SensorData(Long growingBarnRoomNum) {
        return growingNh3Service.getNh3Data(growingBarnRoomNum);
    }

    public List<Growing_Nh3Response> getAllNh3Data() {
        return growingNh3Service.getAllNh3Data();
    }

    public void exportGrowing_Nh3DataToExcel(String filePath) throws IOException {
        growingNh3Service.exportNh3DataToExcel(filePath);
    }
}
