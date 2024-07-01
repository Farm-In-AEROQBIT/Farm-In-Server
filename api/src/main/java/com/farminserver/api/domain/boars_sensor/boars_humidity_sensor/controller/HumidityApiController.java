package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.HumidityResponse;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.business.HumidityBusiness;
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
public class HumidityApiController {

    private final HumidityBusiness humidityBusiness;

    @Autowired
    public HumidityApiController(HumidityBusiness humidityBusiness) {
        this.humidityBusiness = humidityBusiness;
    }

    @GetMapping("/data")
    public HumidityResponse getHumiditySensorData() {
        return humidityBusiness.getHumiditySensorData();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "humidity_data.xlsx";
        try {
            humidityBusiness.exportHumidityDataToExcel(filePath);
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
