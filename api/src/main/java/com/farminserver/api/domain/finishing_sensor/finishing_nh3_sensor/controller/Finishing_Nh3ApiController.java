package com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller;

import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller.model.Finishing_Nh3Response;
import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.business.Finishing_Nh3Business;
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
@RequestMapping("/api/finishing_nh3")
public class Finishing_Nh3ApiController {

    private final Finishing_Nh3Business finishingNh3Business;

    @Autowired
    public Finishing_Nh3ApiController(Finishing_Nh3Business Nh3Business) {
        this.finishingNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{finishingBarnRoomNum}")
    public ResponseEntity<Finishing_Nh3Response> getNh3SensorData(@PathVariable Long finishingBarnRoomNum) {
        return ResponseEntity.ok(finishingNh3Business.getNh3SensorData(finishingBarnRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "finishing_nh3_data.xlsx";
        try {
            finishingNh3Business.exportFinishing_Nh3DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=finishing_nh3_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
