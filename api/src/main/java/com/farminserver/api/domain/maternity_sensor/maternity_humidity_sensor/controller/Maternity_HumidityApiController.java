package com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.controller;

import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.business.Maternity_HumidityBusiness;
import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.controller.model.Maternity_HumidityResponse;
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
@RequestMapping("/api/maternity_humidity")
public class Maternity_HumidityApiController {

    private final Maternity_HumidityBusiness maternityHumidityBusiness;

    @Autowired
    public Maternity_HumidityApiController(Maternity_HumidityBusiness HumidityBusiness) {
        this.maternityHumidityBusiness = HumidityBusiness;
    }

    @GetMapping("/humiditydata/{maternityRoomNum}")
    public ResponseEntity<Maternity_HumidityResponse> getHumiditySensorData(@PathVariable String maternityRoomNum) {
        return ResponseEntity.ok(maternityHumidityBusiness.getHumiditySensorData(maternityRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportHumidityData() {
        String filePath = "maternity_humidity_data.xlsx";
        try {
            maternityHumidityBusiness.exportHumidityDataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=maternity_humidity_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
