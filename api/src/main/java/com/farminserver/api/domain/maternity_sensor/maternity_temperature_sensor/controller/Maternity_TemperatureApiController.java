package com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.controller;

import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.business.Maternity_TemperatureBusiness;
import com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.controller.model.Maternity_TemperatureResponse;
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
@RequestMapping("/api/maternity_temperature")
public class Maternity_TemperatureApiController {

    private final Maternity_TemperatureBusiness maternityTemperatureBusiness;

    @Autowired
    public Maternity_TemperatureApiController(Maternity_TemperatureBusiness maternityTemperatureBusiness) {
        this.maternityTemperatureBusiness = maternityTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{maternityRoomNum}")
    public ResponseEntity<Maternity_TemperatureResponse> getTemperatureSensorData(@PathVariable Long maternityRoomNum) {
        return ResponseEntity.ok(maternityTemperatureBusiness.getTemperatureSensorData(maternityRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "maternity_temperature_data.xlsx";
        try {
            maternityTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=maternity_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
