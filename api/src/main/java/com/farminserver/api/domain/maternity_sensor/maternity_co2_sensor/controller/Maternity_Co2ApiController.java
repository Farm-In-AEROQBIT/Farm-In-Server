package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller;

import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.business.Maternity_Co2Business;
import com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller.model.Maternity_Co2Response;
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
@RequestMapping("v1/api/maternity_co2")
public class Maternity_Co2ApiController {

    private final Maternity_Co2Business maternityCo2Business;

    @Autowired
    public Maternity_Co2ApiController(Maternity_Co2Business co2Business) {
        this.maternityCo2Business = co2Business;
    }

    @GetMapping("/co2data/{maternityRoomNum}")
    public ResponseEntity<Maternity_Co2Response> getCo2SensorData(@PathVariable Long maternityRoomNum) {
        return ResponseEntity.ok(maternityCo2Business.getCo2SensorData(maternityRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "maternity_co2_data.xlsx";
        try {
            maternityCo2Business.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=maternity_co2_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

