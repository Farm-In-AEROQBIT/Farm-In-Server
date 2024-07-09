package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller;

import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.business.Reserve_Co2Business;
import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.controller.model.Reserve_Co2Response;
import com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.business.Reserve_Co2Business;
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
@RequestMapping("/api/reserve_humidity")
public class Reserve_HumidityApiController {

    private final Reserve_Co2Business reserveCo2Business;

    @Autowired
    public Reserve_Co2ApiController(Reserve_Co2Business co2Business) {
        this.reserveCo2Business = co2Business;
    }

    @GetMapping("/humiditydata/{reserveBarnRoomNum}")
    public ResponseEntity<Reserve_Co2Response> getCo2SensorData(@PathVariable String reserveBarnRoomNum) {
        return ResponseEntity.ok(reserveCo2Business.getCo2SensorData(reserveBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "reserve_co2_data.xlsx";
        try {
            reserveCo2Business.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reserve_humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
