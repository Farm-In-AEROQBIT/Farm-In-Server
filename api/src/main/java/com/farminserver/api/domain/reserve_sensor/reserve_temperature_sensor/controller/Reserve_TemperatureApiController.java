package com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.controller;

import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.controller.model.Reserve_TemperatureResponse;
import com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.business.Reserve_TemperatureBusiness;
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
@RequestMapping("v1/api/reserve_temperature")
public class Reserve_TemperatureApiController {

    private final Reserve_TemperatureBusiness reserveTemperatureBusiness;

    @Autowired
    public Reserve_TemperatureApiController(Reserve_TemperatureBusiness reserveTemperatureBusiness) {
        this.reserveTemperatureBusiness = reserveTemperatureBusiness;
    }

    @GetMapping("/temperaturedata/{reserveSowsRoomNum}")
    public ResponseEntity<Reserve_TemperatureResponse> getTemperatureSensorData(@PathVariable Long reserveSowsRoomNum) {
        return ResponseEntity.ok(reserveTemperatureBusiness.getTemperatureSensorData(reserveSowsRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportTemperatureData() {
        String filePath = "reserve_temperature_data.xlsx";
        try {
            reserveTemperatureBusiness.exportTemperatureDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reserve_temperature_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
