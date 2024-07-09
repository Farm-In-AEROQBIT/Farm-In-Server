package com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller;

import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.business.Piglet_TemperatureBusiness;
import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller.model.Piglet_TemperatureResponse;
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
@RequestMapping("/api/piglet_temperature")
public class Piglet_TemperatureApiController {

    private final Piglet_TemperatureBusiness pigletTemperatureBusiness;

    @Autowired
    public Piglet_TemperatureApiController(Piglet_TemperatureBusiness pigletTemperatureBusiness) {
        this.pigletTemperatureBusiness = pigletTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{pigletRoomNum}")
    public ResponseEntity<Piglet_TemperatureResponse> getTemperatureSensorData(@PathVariable String pigletRoomNum) {
        return ResponseEntity.ok(pigletTemperatureBusiness.getTemperatureSensorData(pigletRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "piglet_temperature_data.xlsx";
        try {
            pigletTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=piglet_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
