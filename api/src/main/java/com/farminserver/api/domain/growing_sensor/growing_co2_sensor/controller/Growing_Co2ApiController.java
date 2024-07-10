package com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller;

import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.business.Growing_Co2Business;
import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller.model.Growing_Co2Response;
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
@RequestMapping("/api/growing_co2")
public class Growing_Co2ApiController {

    private final Growing_Co2Business growingCo2Business;

    @Autowired
    public Growing_Co2ApiController(Growing_Co2Business co2Business) {
        this.growingCo2Business = co2Business;
    }

    @GetMapping("/co2data/{growingBarnRoomNum}")
    public ResponseEntity<Growing_Co2Response> getCo2SensorData(@PathVariable Long growingBarnRoomNum) {
        return ResponseEntity.ok(growingCo2Business.getCo2SensorData(growingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "growing_co2_data.xlsx";
        try {
            growingCo2Business.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=growing_co2_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
