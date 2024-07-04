package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.business.Boars_Nh3Business;
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
@RequestMapping("/api/boars_nh3")
public class Boars_Nh3ApiController {

    private final Boars_Nh3Business boarsNh3Business;

    @Autowired
    public Boars_Nh3ApiController(Boars_Nh3Business Nh3Business) {
        this.boarsNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{boarsBarnRoomNum}")
    public ResponseEntity<Boars_Nh3Response> getNh3SensorData(@PathVariable String boarsBarnRoomNum) {
        return ResponseEntity.ok(boarsNh3Business.getNh3SensorData(boarsBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "baors_nh3_data.xlsx";
        try {
            boarsNh3Business.exportBoars_Nh3DataToExcel(filePath);
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
