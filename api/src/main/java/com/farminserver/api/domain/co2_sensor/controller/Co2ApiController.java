package com.farminserver.api.domain.co2_sensor.controller;

import com.farminserver.api.domain.co2_sensor.business.Co2Business;
import com.farminserver.api.domain.co2_sensor.controller.model.Co2Response;
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
@RequestMapping("/api/co2")
public class Co2ApiController {

    private final Co2Business co2Business;

    @Autowired
    public Co2ApiController(Co2Business co2Business) {
        this.co2Business = co2Business;
    }

    @GetMapping("/co2data")
    public Co2Response getCo2SensorData() {
        return co2Business.getCo2SensorData();
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
