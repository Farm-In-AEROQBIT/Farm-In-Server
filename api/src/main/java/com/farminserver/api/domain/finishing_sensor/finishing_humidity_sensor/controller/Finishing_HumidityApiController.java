package com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller;

import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.business.Finishing_HumidityBusiness;
import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model.Finishing_HumidityResponse;
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
@RequestMapping("/api/finishing_humidity")
public class Finishing_HumidityApiController {

    private final Finishing_HumidityBusiness finishingHumidityBusiness;

    @Autowired
    public Finishing_HumidityApiController(Finishing_HumidityBusiness HumidityBusiness) {
        this.finishingHumidityBusiness = HumidityBusiness;
    }

    @GetMapping("/humiditydata/{finishingBarnRoomNum}")
    public ResponseEntity<Finishing_HumidityResponse> getHumiditySensorData(@PathVariable Long finishingBarnRoomNum) {
        return ResponseEntity.ok(finishingHumidityBusiness.getHumiditySensorData(finishingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "finishing_humidity_data.xlsx";
        try {
            finishingHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=finishing_humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
