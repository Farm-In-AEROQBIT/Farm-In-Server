package com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.controller;

import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.business.Maternity_PmBusiness;
import com.farminserver.api.domain.maternity_sensor.maternity_pm_sensor.controller.model.Maternity_PmResponse;
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
@RequestMapping("/api/maternity_pm")
public class Maternity_PmApiController {

    private final Maternity_PmBusiness maternityPmBusiness;

    @Autowired
    public Maternity_PmApiController(Maternity_PmBusiness maternityPmBusiness) {
        this.maternityPmBusiness = maternityPmBusiness;
    }

    @GetMapping("/pmdata/{maternityRoomNum}")
    public ResponseEntity<Maternity_PmResponse> getPmSensorData(@PathVariable String maternityRoomNum) {
        return ResponseEntity.ok(maternityPmBusiness.getPmSensorData(maternityRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "pm_data.xlsx";
        try {
            maternityPmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=maternity_pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
