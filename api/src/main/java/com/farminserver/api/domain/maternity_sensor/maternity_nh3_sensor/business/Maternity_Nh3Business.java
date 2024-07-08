package com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.business;

import com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.controller.model.Maternity_Nh3Response;
import com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.service.Maternity_Nh3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Maternity_Nh3Business {

    private final Maternity_Nh3Service maternityNh3Service;

    @Autowired
    public Maternity_Nh3Business(Maternity_Nh3Service nh3Service) {
        this.maternityNh3Service = nh3Service;
    }

    public Maternity_Nh3Response getNh3SensorData(String maternityRoomNum) {
        return maternityNh3Service.getNh3Data(maternityRoomNum);
    }

    public List<Maternity_Nh3Response> getAllCo2Data() {
        return maternityNh3Service.getAllNh3Data();
    }

    public void exportMaternity_Nh3DataToExcel(String filePath) throws IOException {
        maternityNh3Service.exportCo2DataToExcel(filePath);
    }
}
