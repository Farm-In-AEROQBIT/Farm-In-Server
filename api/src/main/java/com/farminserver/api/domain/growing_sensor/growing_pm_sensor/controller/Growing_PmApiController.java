package com.farminserver.api.domain.growing_sensor.growing_pm_sensor.controller;

import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.business.Growing_PmBusiness;
import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.controller.model.Growing_PmResponse;
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
@RequestMapping("/api/growing_om")
public class Growing_PmApiController {

    private final Growing_PmBusiness growingPmBusiness;

    @Autowired
    public Growing_PmApiController(Growing_PmBusiness growingPmBusiness) {
        this.growingPmBusiness = growingPmBusiness;
    }

    @GetMapping("/pmdata/{growingRoomNum}")
    public ResponseEntity<Growing_PmResponse> getPmSensorData(@PathVariable Long growingRoomNum) {
        return ResponseEntity.ok(growingPmBusiness.getPmSensorData(growingRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "growing_pm_data.xlsx";
        try {
            growingPmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=growing_pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
