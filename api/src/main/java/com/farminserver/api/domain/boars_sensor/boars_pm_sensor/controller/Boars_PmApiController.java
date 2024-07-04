package com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.business.Boars_PmBusiness;
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
@RequestMapping("/api/boars_pm")
public class Boars_PmApiController {

    private final Boars_PmBusiness boarsPmBusiness;

    @Autowired
    public Boars_PmApiController(Boars_PmBusiness boarsPmBusiness) {
        this.boarsPmBusiness = boarsPmBusiness;
    }

    @GetMapping("/pmdata/{boarsBarnRoomNum}")
    public ResponseEntity<Boars_PmResponse> getPmSensorData(@PathVariable String boarsBarnRoomNum) {
        return ResponseEntity.ok(boarsPmBusiness.getPmSensorData(boarsBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "pm_data.xlsx";
        try {
            boarsPmBusiness.exportPmDataToExcel(filePath);
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
