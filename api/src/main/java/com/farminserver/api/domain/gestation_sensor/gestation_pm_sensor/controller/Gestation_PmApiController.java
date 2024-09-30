package com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller;

import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.business.Gestation_PmBusiness;
import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller.model.Gestation_PmResponse;
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
@RequestMapping("v1/api/gestation_pm")
public class Gestation_PmApiController {

    private final Gestation_PmBusiness gestationPmBusiness;

    @Autowired
    public Gestation_PmApiController(Gestation_PmBusiness gestationPmBusiness) {
        this.gestationPmBusiness = gestationPmBusiness;
    }

    @GetMapping("/pmdata/{gestationRoomNum}")
    public ResponseEntity<Gestation_PmResponse> getPmSensorData(@PathVariable Long gestationRoomNum) {
        return ResponseEntity.ok(gestationPmBusiness.getPmSensorData(gestationRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "pm_data.xlsx";
        try {
            gestationPmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
