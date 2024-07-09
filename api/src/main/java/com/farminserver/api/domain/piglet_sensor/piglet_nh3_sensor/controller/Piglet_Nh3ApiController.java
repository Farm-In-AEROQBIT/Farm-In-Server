package com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller;
import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.business.Piglet_Nh3Business;
import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller.model.Piglet_Nh3Response;
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
@RequestMapping("/api/piglet_nh3")
public class Piglet_Nh3ApiController {

    private final Piglet_Nh3Business pigletNh3Business;

    @Autowired
    public Piglet_Nh3ApiController(Piglet_Nh3Business Nh3Business) {
        this.pigletNh3Business = Nh3Business;
    }

    @GetMapping("/nh3data/{pigletRoomNum}")
    public ResponseEntity<Piglet_Nh3Response> getNh3SensorData(@PathVariable String pigletRoomNum) {
        return ResponseEntity.ok(pigletNh3Business.getNh3SensorData(pigletRoomNum));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportNh3Data() {
        String filePath = "baors_nh3_data.xlsx";
        try {
            pigletNh3Business.exportPiglet_Nh3DataToExcel(filePath);
            Resource resource = new FileSystemResource(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=nh3_data.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
