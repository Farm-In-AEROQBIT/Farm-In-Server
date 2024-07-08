package com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.business;

import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.service.Finishing_Co2Service;
import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller.model.Finishing_Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Finishing_Co2Business {

    private final Finishing_Co2Service finishingCo2Service;

    @Autowired
    public Finishing_Co2Business(Finishing_Co2Service co2Service) {
        this.finishingCo2Service = co2Service;
    }

    public Finishing_Co2Response getCo2SensorData(String finishingBarnRoomNum) {
        return finishingCo2Service.getCo2Data(finishingBarnRoomNum);
    }

    public List<Finishing_Co2Response> getAllCo2Data() {
        return finishingCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        finishingCo2Service.exportCo2DataToExcel(filePath);
    }
}
