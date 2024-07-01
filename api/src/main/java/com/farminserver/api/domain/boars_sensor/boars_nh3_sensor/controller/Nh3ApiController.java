package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.business.Nh3Business;
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
@RequestMapping("/api/nh3")
public class Nh3ApiController {

    private final Nh3Business nh3Business;

    @Autowired
    public Nh3ApiController(Nh3Business nh3Business) {
        this.nh3Business = nh3Business;
    }

    @GetMapping("/nh3data")
    public Nh3Response getNh3SensorData() {
        return nh3Business.getNh3SensorData();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "nh3_data.xlsx";
        try {
            nh3Business.exportNh3DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=nh3_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
