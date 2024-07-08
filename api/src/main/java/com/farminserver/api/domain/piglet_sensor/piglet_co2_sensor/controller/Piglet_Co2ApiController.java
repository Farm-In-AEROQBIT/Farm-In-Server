package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business.Boars_Co2Business;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business.UserBusiness;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boar_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.business.Piglet_Co2Business;
import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller.model.Piglet_Co2Response;
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
@RequestMapping("/api/piglet_co2")
public class Piglet_Co2ApiController {

    private final Piglet_Co2Business pigletCo2Business;

    @Autowired
    public Piglet_Co2ApiController(Piglet_Co2Business co2Business) {
        this.pigletCo2Business = co2Business;
    }

    @GetMapping("/co2data/{pigletBarnRoomNum}")
    public ResponseEntity<Piglet_Co2Response> getCo2SensorData(@PathVariable String boarsBarnRoomNum) {
        return ResponseEntity.ok(pigletCo2Business.getCo2SensorData(boarsBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "piglet_co2_data.xlsx";
        try {
            pigletCo2Business.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=co2_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
