package com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller;

import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.business.Piglet_PmBusiness;
import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller.model.Piglet_PmResponse;
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
@RequestMapping("v1/api/piglet_pm")
public class Piglet_PmApiController {

    private final Piglet_PmBusiness pigletPmBusiness;

    @Autowired
    public Piglet_PmApiController(Piglet_PmBusiness pigletPmBusiness) {
        this.pigletPmBusiness = pigletPmBusiness;
    }

    @GetMapping("/pmdata/{pigletRoomNum}")
    public ResponseEntity<Piglet_PmResponse> getPmSensorData(@PathVariable Long pigletRoomNum) {
        return ResponseEntity.ok(pigletPmBusiness.getPmSensorData(pigletRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "piglet_pm_data.xlsx";
        try {
            pigletPmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=piglet_pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
