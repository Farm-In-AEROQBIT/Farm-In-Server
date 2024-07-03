package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business.Boars_Co2Business;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
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
@RequestMapping("/api/boars_co2")
public class Boars_Co2ApiController {

    private final Boars_Co2Business co2Business;

    @Autowired
    public Boars_Co2ApiController(Boars_Co2Business co2Business) {
        this.co2Business = co2Business;
    }

    @GetMapping("/co2data/{boarsBarnRoomNum}")
    public ResponseEntity<Boars_Co2Response> getCo2SensorData(@PathVariable String boarsBarnRoomNum) {
        return ResponseEntity.ok(co2Business.getCo2SensorData(boarsBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "co2_data.xlsx";
        try {
            co2Business.exportCo2DataToExcel(filePath);
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
