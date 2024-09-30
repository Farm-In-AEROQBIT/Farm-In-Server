package com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller;

import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller.model.Finishing_PmResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.business.Finishing_PmBusiness;
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
@RequestMapping("v1/api/finishing_pm")
public class Finishing_PmApiController {

    private final Finishing_PmBusiness finishingPmBusiness;

    @Autowired
    public Finishing_PmApiController(Finishing_PmBusiness finishingPmBusiness) {
        this.finishingPmBusiness = finishingPmBusiness;
    }

    @GetMapping("/pmdata/{finishingBarnRoomNum}")
    public ResponseEntity<Finishing_PmResponse> getPmSensorData(@PathVariable Long finishingBarnRoomNum) {
        return ResponseEntity.ok(finishingPmBusiness.getPmSensorData(finishingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportPmData() {
        String filePath = "finishing_pm_data.xlsx";
        try {
            finishingPmBusiness.exportPmDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=finishing_pm_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
