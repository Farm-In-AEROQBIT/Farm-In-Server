package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.service.UserService;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Piglet_HumidityBusiness {

    private final UserService userService;

    @Autowired
    public Piglet_HumidityBusiness(UserService userService) {
        this.userService = userService;
    }

    public UserResponse getCo2SensorData() {
        double co2Data = userService.getCo2Data();
        return new UserResponse(co2Data, "ppm", System.currentTimeMillis());
    }

    public List<UserResponse> getAllCo2Data() {
        return userService.getAllCo2Data();
    }

    public void exportCo2DataToExcel(String filePath) throws IOException {
        userService.exportCo2DataToExcel(filePath);
    }
}
