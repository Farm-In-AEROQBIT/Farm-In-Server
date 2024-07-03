package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.Boars_HumidityResponse;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.business.Boars_HumidityBusiness;
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
@RequestMapping("/api/humidity")
public class Boars_HumidityApiController {

    private final Boars_HumidityBusiness boarsHumidityBusiness;

    @Autowired
    public Boars_HumidityApiController(Boars_HumidityBusiness boarsHumidityBusiness) {
        this.boarsHumidityBusiness = boarsHumidityBusiness;
    }

    @GetMapping("/data")
    public Boars_HumidityResponse getHumiditySensorData() {
        return boarsHumidityBusiness.getHumiditySensorData();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "humidity_data.xlsx";
        try {
            boarsHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
