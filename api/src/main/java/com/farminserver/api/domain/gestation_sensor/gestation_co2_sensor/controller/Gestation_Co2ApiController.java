package com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller;

import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.business.Gestation_Co2Business;
import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller.model.Gestation_Co2Response;
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
@RequestMapping("v1/api/gestation_co2")
public class Gestation_Co2ApiController {

    private final Gestation_Co2Business gestationCo2Business;

    @Autowired
    public Gestation_Co2ApiController(Gestation_Co2Business co2Business) {
        this.gestationCo2Business = co2Business;
    }

    @GetMapping("/co2data/{gestationBarnRoomNum}")
    public ResponseEntity<Gestation_Co2Response> getCo2SensorData(@PathVariable Long gestationBarnRoomNum) {
        return ResponseEntity.ok(gestationCo2Business.getCo2SensorData(gestationBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "gestation_co2_data.xlsx";
        try {
            gestationCo2Business.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=gestation_co2_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
