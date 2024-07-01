package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.business.PmBusiness;
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
@RequestMapping("/api/pm")
public class PmApiController {

    private final PmBusiness pmBusiness;

    @Autowired
    public PmApiController(PmBusiness pmBusiness) {
        this.pmBusiness = pmBusiness;
    }

    @GetMapping("/pmdata")
    public PmResponse getPmSensorData() {
        return pmBusiness.getPmSensorData();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "pm_data.xlsx";
        try {
            pmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
