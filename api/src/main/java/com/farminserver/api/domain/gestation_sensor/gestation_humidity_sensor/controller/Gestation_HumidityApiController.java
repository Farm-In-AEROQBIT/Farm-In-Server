package com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller;

import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.business.Gestation_HumidityBusiness;
import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller.model.Gestation_HumidityResponse;
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
@RequestMapping("/api/gestation_humidity")
public class Gestation_HumidityApiController {

    private final Gestation_HumidityBusiness gestationHumidityBusiness;

    @Autowired
    public Gestation_HumidityApiController(Gestation_HumidityBusiness HumidityBusiness) {
        this.gestationHumidityBusiness = HumidityBusiness;
    }

    @GetMapping("/humiditydata/{gestationBarnRoomNum}")
    public ResponseEntity<Gestation_HumidityResponse> getHumiditySensorData(@PathVariable Long gestationBarnRoomNum) {
        return ResponseEntity.ok(gestationHumidityBusiness.getHumiditySensorData(gestationBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "gestation_humidity_data.xlsx";
        try {
            gestationHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=gestation_humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
