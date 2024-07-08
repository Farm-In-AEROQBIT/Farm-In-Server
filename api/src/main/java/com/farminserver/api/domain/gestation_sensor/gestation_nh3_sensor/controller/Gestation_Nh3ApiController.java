package com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller;

import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.business.Gestation_Nh3Business;
import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller.model.Gestation_Nh3Response;
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
@RequestMapping("/api/gestation_nh3")
public class Gestation_Nh3ApiController {

    private final Gestation_Nh3Business gestationNh3Business;

    @Autowired
    public Gestation_Nh3ApiController(Gestation_Nh3Business Nh3Business) {
        this.gestationNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{gestationBarnRoomNum}")
    public ResponseEntity<Gestation_Nh3Response> getNh3SensorData(@PathVariable String gestationRoomNum) {
        return ResponseEntity.ok(gestationNh3Business.getNh3SensorData(gestationRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "gestation_nh3_data.xlsx";
        try {
            gestationNh3Business.exportGestation_Nh3DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=gestation_nh3_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
