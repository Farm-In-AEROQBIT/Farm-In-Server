package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.service;

import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller.model.Reserve_HumidityResponse;
import com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.converter.Reserve_HumidityConverter;
import com.farminserver.api.util.ExcelExporter.Reserve_ExcelExporter;
import com.farminserver.db.reserve_humidity_sensor.Reserve_HumiditySensorEntity;
import com.farminserver.db.reserve_humidity_sensor.Reserve_HumiditySensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Reserve_HumidityService {

    private final Reserve_HumiditySensorRepository repository;
    private final Reserve_HumidityConverter converter;
    private final Reserve_ExcelExporter reserveExcelExporter;

    @Autowired
    public Reserve_HumidityService(Reserve_HumiditySensorRepository repository, Reserve_HumidityConverter converter, Reserve_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.reserveExcelExporter = excelExporter;
    }

    public Reserve_HumidityResponse getHumidityData(Long reserveSowsRoomNum) {
        Reserve_HumiditySensorEntity entity = repository.findById(reserveSowsRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Reserve_HumidityResponse> getAllHumidityData() {
        List<Reserve_HumiditySensorEntity> entities = repository.findAll();
        List<Reserve_HumidityResponse> responses = new ArrayList<>();
        for (Reserve_HumiditySensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    /*public List<Reserve_HumidityResponse> getAllHumidityData() {
        List<Reserve_HumidityResponse> responses = new ArrayList<>();
        responses.add(new Reserve_HumidityResponse(55.0, "%", System.currentTimeMillis()));
        responses.add(new Reserve_HumidityResponse(56.0, "%", System.currentTimeMillis() - 10000));
        return responses;
    }*/

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Reserve_HumidityResponse> reserveHumidityResponse = getAllHumidityData();
        reserveExcelExporter.exportReserve_humidityData(reserveHumidityResponse, filePath);
    }
}
