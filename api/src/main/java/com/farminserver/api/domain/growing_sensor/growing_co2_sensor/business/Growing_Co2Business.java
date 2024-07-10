package com.farminserver.api.domain.growing_sensor.growing_co2_sensor.business;

import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.service.Growing_Co2Service;
import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller.model.Growing_Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Growing_Co2Business {

    private final Growing_Co2Service growingCo2Service;

    @Autowired
    public Growing_Co2Business(Growing_Co2Service co2Service) {
        this.growingCo2Service = co2Service;
    }

    public Growing_Co2Response getCo2SensorData(Long growingBarnRoomNum) {
        return growingCo2Service.getCo2Data(growingBarnRoomNum);
    }

    public List<Growing_Co2Response> getAllCo2Data() {
        return growingCo2Service.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        growingCo2Service.exportCo2DataToExcel(filePath);
    }
}
