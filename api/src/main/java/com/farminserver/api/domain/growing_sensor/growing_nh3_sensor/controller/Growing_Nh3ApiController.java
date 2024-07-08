package com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller;

import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller.model.Growing_Nh3Response;
import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.business.Growing_Nh3Business;
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
@RequestMapping("/api/growing_nh3")
public class Growing_Nh3ApiController {

    private final Growing_Nh3Business growingNh3Business;

    @Autowired
    public Growing_Nh3ApiController(Growing_Nh3Business Nh3Business) {
        this.growingNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{growingBarnRoomNum}")
    public ResponseEntity<Growing_Nh3Response> getNh3SensorData(@PathVariable String growingBarnRoomNum) {
        return ResponseEntity.ok(growingNh3Business.getNh3SensorData(growingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "growing_nh3_data.xlsx";
        try {
            growingNh3Business.exportGrowing_Nh3DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=growing_nh3_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
