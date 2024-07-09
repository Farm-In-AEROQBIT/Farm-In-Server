package com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.business.Boars_Nh3Business;
import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.business.Reserve_Nh3Business;
import com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller.model.Reserve_Nh3Response;
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
@RequestMapping("/api/reserve_nh3")
public class Reserve_Nh3ApiController {

    private final Reserve_Nh3Business reserveNh3Business;

    @Autowired
    public Reserve_Nh3ApiController(Reserve_Nh3Business Nh3Business) {
        this.reserveNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{reserveSowsRoomNum}")
    public ResponseEntity<Reserve_Nh3Response> getNh3SensorData(@PathVariable String reserveSowsRoomNum) {
        return ResponseEntity.ok(reserveNh3Business.getNh3SensorData(reserveSowsRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "reserve_nh3_data.xlsx";
        try {
            reserveNh3Business.exportReserve_Nh3DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reserve_nh3_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
