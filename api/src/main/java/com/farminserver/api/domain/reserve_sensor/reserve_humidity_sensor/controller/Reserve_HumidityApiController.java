package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller;

import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.business.Reserve_HumidityBusiness;
import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller.model.Reserve_HumidityResponse;
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
@RequestMapping("/api/reserve_humidity")
public class Reserve_HumidityApiController {

    private final Reserve_HumidityBusiness reserveHumidityBusiness;

    @Autowired
    public Reserve_HumidityApiController(Reserve_HumidityBusiness HumidityBusiness) {
        this.reserveHumidityBusiness = HumidityBusiness;
    }

    @GetMapping("/humiditydata/{reserveBarnRoomNum}")
    public ResponseEntity<Reserve_HumidityResponse> getHumiditySensorData(@PathVariable String reserveBarnRoomNum) {
        return ResponseEntity.ok(reserveHumidityBusiness.getHumiditySensorData(reserveBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "reserve_humidity_data.xlsx";
        try {
            reserveHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reserve_humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
