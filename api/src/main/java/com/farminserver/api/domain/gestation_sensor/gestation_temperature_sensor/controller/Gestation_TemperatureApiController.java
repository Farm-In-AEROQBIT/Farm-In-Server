package com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller;

import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller.model.Gestation_TemperatureResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.business.Gestation_TemperatureBusiness;
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
@RequestMapping("/api/gestation_temperature")
public class Gestation_TemperatureApiController {

    private final Gestation_TemperatureBusiness gestationTemperatureBusiness;

    @Autowired
    public Gestation_TemperatureApiController(Gestation_TemperatureBusiness gestationTemperatureBusiness) {
        this.gestationTemperatureBusiness = gestationTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{gestationRoomNum}")
    public ResponseEntity<Gestation_TemperatureResponse> getTemperatureSensorData(@PathVariable Long gestationRoomNum) {
        return ResponseEntity.ok(gestationTemperatureBusiness.getTemperatureSensorData(gestationRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "gestation_temperature_data.xlsx";
        try {
            gestationTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=gestation_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
