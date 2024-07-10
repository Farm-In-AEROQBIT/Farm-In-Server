package com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.controller;

import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.business.Reserve_PmBusiness;
import com.farminserver.api.domain.reserve_sensor.reserve_pm_sensor.controller.model.Reserve_PmResponse;
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
@RequestMapping("/api/reserve_pm")
public class Reserve_PmApiController {

    private final Reserve_PmBusiness reservePmBusiness;

    @Autowired
    public Reserve_PmApiController(Reserve_PmBusiness reservePmBusiness) {
        this.reservePmBusiness = reservePmBusiness;
    }

    @GetMapping("/pmdata/{reserveSowsRoomNum}")
    public ResponseEntity<Reserve_PmResponse> getPmSensorData(@PathVariable Long reserveSowsRoomNum) {
        return ResponseEntity.ok(reservePmBusiness.getPmSensorData(reserveSowsRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "reserve_pm_data.xlsx";
        try {
            reservePmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reserve_pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
