package com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller;

import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.business.Growing_HumidityBusiness;
import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller.model.Growing_HumidityResponse;
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
@RequestMapping("v1/api/growing_humidity")
public class Growing_HumidityApiController {

    private final Growing_HumidityBusiness growingHumidityBusiness;

    @Autowired
    public Growing_HumidityApiController(Growing_HumidityBusiness HumidityBusiness) {
        this.growingHumidityBusiness = HumidityBusiness;
    }

    @GetMapping("/humiditydata/{growingBarnRoomNum}")
    public ResponseEntity<Growing_HumidityResponse> getHumiditySensorData(@PathVariable Long growingBarnRoomNum) {
        return ResponseEntity.ok(growingHumidityBusiness.getHumiditySensorData(growingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "growing_humidity_data.xlsx";
        try {
            growingHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=growing_humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
