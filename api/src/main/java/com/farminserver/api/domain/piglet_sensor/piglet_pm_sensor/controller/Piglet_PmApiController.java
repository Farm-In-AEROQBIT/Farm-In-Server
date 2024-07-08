package com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business.UserBusiness;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/boars_co2")
public class Piglet_PmApiController {

    private final UserBusiness userBusiness;

    @Autowired
    public Piglet_PmApiController(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @GetMapping("/co2data")
    public UserResponse getCo2SensorData() {
        return userBusiness.getCo2SensorData();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "co2_data.xlsx";
        try {
            userBusiness.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=co2_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
