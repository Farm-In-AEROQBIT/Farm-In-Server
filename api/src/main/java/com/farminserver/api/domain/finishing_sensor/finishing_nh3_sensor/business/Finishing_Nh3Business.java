package com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.business;

import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.service.Finishing_Nh3Service;
import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller.model.Finishing_Nh3Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Finishing_Nh3Business {

    private final Finishing_Nh3Service finishingNh3Service;

    @Autowired
    public Finishing_Nh3Business(Finishing_Nh3Service nh3Service) {
        this.finishingNh3Service = nh3Service;
    }

    public Finishing_Nh3Response getNh3SensorData(Long finishingBarnRoomNum) {
        return finishingNh3Service.getNh3Data(finishingBarnRoomNum);
    }

    public List<Finishing_Nh3Response> getAllNh3Data() {
        return finishingNh3Service.getAllNh3Data();
    }

    public void exportFinishing_Nh3DataToExcel(String filePath) throws IOException {
        finishingNh3Service.exportNh3DataToExcel(filePath);
    }
}
