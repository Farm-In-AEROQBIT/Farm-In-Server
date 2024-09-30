package com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller;

import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.business.Finishing_Co2Business;
import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller.model.Finishing_Co2Response;
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
@RequestMapping("v1/api/finishing_co2")
public class Finishing_Co2ApiController {

    private final Finishing_Co2Business finishingCo2Business;

    @Autowired
    public Finishing_Co2ApiController(Finishing_Co2Business finishing_co2Business) {
        this.finishingCo2Business = finishing_co2Business;
    }

    @GetMapping("/co2data/{finishingBarnRoomNum}")
    public ResponseEntity<Finishing_Co2Response> getCo2SensorData(@PathVariable Long finihsingBarnRoomNum) {
        return ResponseEntity.ok(finishingCo2Business.getCo2SensorData(finihsingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportCo2Data() {
        String filePath = "finishing_co2_data.xlsx";
        try {
            finishingCo2Business.exportCo2DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=finishing_co2_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}