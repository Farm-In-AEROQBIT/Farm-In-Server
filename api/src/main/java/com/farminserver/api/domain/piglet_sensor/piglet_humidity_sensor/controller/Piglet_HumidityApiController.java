package com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller;

import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.business.Piglet_HumidityBusiness;
import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller.model.Piglet_HumidityResponse;
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
@RequestMapping("/api/piglet_humidity")
public class Piglet_HumidityApiController {

    private final Piglet_HumidityBusiness pigletHumidityBusiness;

    @Autowired
    public Piglet_HumidityApiController(Piglet_HumidityBusiness HumidityBusiness) {
        this.pigletHumidityBusiness = HumidityBusiness;
    }

    @GetMapping("/humiditydata/{pigletRoomNum}")
    public ResponseEntity<Piglet_HumidityResponse> getHumiditySensorData(@PathVariable String pigletRoomNum) {
        return ResponseEntity.ok(pigletHumidityBusiness.getHumiditySensorData(pigletRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "piglet_humidity_data.xlsx";
        try {
            pigletHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
