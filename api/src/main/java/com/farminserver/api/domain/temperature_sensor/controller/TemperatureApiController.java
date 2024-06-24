package com.farminserver.api.domain.temperature_sensor.controller;

import com.farminserver.api.domain.temperature_sensor.business.TemperatureBusiness;
import com.farminserver.api.domain.temperature_sensor.controller.model.TemperatureResponse;
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
@RequestMapping("/api/temperature")
public class TemperatureApiController {

    private final TemperatureBusiness temperatureBusiness;

    @Autowired
    public TemperatureApiController(TemperatureBusiness temperatureBusiness) {
        this.temperatureBusiness = temperatureBusiness;
    }

    @GetMapping("/temperaturedata")
    public TemperatureResponse getTemperatureSensorData() {
        return temperatureBusiness.getTemperatureSensorData();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "temperature_data.xlsx";
        try {
            temperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
