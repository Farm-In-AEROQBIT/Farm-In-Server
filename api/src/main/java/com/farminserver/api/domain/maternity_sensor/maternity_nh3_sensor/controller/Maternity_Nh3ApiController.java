package com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.controller;


import com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.business.Maternity_Nh3Business;
import com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.controller.model.Maternity_Nh3Response;
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
@RequestMapping("/api/maternity_nh3")
public class Maternity_Nh3ApiController {

    private final Maternity_Nh3Business maternityNh3Business;

    @Autowired
    public Maternity_Nh3ApiController(Maternity_Nh3Business Nh3Business) {
        this.maternityNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{maternityRoomNum}")
    public ResponseEntity<Maternity_Nh3Response> getNh3SensorData(@PathVariable String maternityRoomNum) {
        return ResponseEntity.ok(maternityNh3Business.getNh3SensorData(maternityRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "maternity_nh3_data.xlsx";
        try {
            maternityNh3Business.exportMaternity_Nh3DataToExcel(filePath);
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
