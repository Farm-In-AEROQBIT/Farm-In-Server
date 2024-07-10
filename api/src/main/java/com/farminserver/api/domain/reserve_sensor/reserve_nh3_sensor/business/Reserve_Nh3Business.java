package com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.business;

import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.service.Reserve_Nh3Service;
import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller.model.Reserve_Nh3Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Reserve_Nh3Business {

    private final Reserve_Nh3Service reserveNh3Service;

    @Autowired
    public Reserve_Nh3Business(Reserve_Nh3Service nh3Service) {
        this.reserveNh3Service = nh3Service;
    }

    public Reserve_Nh3Response getNh3SensorData(Long reserveRoomNum) {
        return reserveNh3Service.getNh3Data(reserveRoomNum);
    }

    public List<Reserve_Nh3Response> getAllNh3Data() {
        return reserveNh3Service.getAllNh3Data();
    }

    public void exportReserve_Nh3DataToExcel(String filePath) throws IOException {
        reserveNh3Service.exportNh3DataToExcel(filePath);
    }
}
