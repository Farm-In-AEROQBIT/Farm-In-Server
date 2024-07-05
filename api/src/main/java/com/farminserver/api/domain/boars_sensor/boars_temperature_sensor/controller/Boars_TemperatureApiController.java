package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.business.Boars_TemperatureBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/boars_temperature")
public class Boars_TemperatureApiController {

    private final Boars_TemperatureBusiness boarsTemperatureBusiness;

    @Autowired
    public Boars_TemperatureApiController(Boars_TemperatureBusiness boarsTemperatureBusiness) {
        this.boarsTemperatureBusiness = boarsTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{boarsBarnRoomNum}")
    public ResponseEntity<Boars_TemperatureResponse> getTemperatureSensorData(@PathVariable String boarsBarnRoomNum) {
        return ResponseEntity.ok(boarsTemperatureBusiness.getTemperatureSensorData(boarsBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "boars_temperature_data.xlsx";
        try {
            boarsTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=finishing_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
