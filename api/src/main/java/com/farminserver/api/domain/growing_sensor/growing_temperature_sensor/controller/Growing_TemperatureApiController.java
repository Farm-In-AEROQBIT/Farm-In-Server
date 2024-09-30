package com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller;

import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.business.Growing_TemperatureBusiness;
import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller.model.Growing_TemperatureResponse;
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
@RequestMapping("v1/api/growing_temperature")
public class Growing_TemperatureApiController {

    private final Growing_TemperatureBusiness growingTemperatureBusiness;

    @Autowired
    public Growing_TemperatureApiController(Growing_TemperatureBusiness growingTemperatureBusiness) {
        this.growingTemperatureBusiness = growingTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{growingRoomNum}")
    public ResponseEntity<Growing_TemperatureResponse> getTemperatureSensorData(@PathVariable Long growingRoomNum) {
        return ResponseEntity.ok(growingTemperatureBusiness.getTemperatureSensorData(growingRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "growing_temperature_data.xlsx";
        try {
            growingTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=growing_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
