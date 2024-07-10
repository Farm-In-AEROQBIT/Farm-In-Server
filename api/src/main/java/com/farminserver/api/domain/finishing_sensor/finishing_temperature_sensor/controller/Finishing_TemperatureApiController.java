package com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller;

import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller.model.Finishing_TemperatureResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.business.Finishing_TemperatureBusiness;
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
@RequestMapping("/api/finishing_temperature")
public class Finishing_TemperatureApiController {

    private final Finishing_TemperatureBusiness finishingTemperatureBusiness;

    @Autowired
    public Finishing_TemperatureApiController(Finishing_TemperatureBusiness finishingTemperatureBusiness) {
        this.finishingTemperatureBusiness = finishingTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{finishingBarnRoomNum}")
    public ResponseEntity<Finishing_TemperatureResponse> getTemperatureSensorData(@PathVariable Long finishingBarnRoomNum) {
        return ResponseEntity.ok(finishingTemperatureBusiness.getTemperatureSensorData(finishingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "finishing_temperature_data.xlsx";
        try {
            finishingTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=finishing_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
