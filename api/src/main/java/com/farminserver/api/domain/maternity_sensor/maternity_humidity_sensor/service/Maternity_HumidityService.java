package com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.service;



import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.controller.model.Maternity_HumidityResponse;
import com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.converter.Maternity_HumidityConverter;
import com.farminserver.api.util.ExcelExporter.Maternity_ExcelExporter;
import com.farminserver.db.maternity_hunmidity_sensor.Maternity_HumiditySensorEntity;
import com.farminserver.db.maternity_hunmidity_sensor.Maternity_HumiditySensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Maternity_HumidityService {

    private final Maternity_HumiditySensorRepository repository;
    private final Maternity_HumidityConverter converter;
    private final Maternity_ExcelExporter maternityExcelExporter;

    @Autowired
    public Maternity_HumidityService(Maternity_HumiditySensorRepository repository, Maternity_HumidityConverter converter, Maternity_ExcelExporter excelExporter) {
        this.repository = repository;
        this.converter = converter;
        this.maternityExcelExporter = excelExporter;
    }

    public Maternity_HumidityResponse getHumidityData(Long maternityRoomNum) {
        Maternity_HumiditySensorEntity entity = repository.findById(maternityRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Maternity_HumidityResponse> getAllHumidityData() {
        List<Maternity_HumiditySensorEntity> entities = repository.findAll();
        List<Maternity_HumidityResponse> responses = new ArrayList<>();
        for (Maternity_HumiditySensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    /*public List<Maternity_HumidityResponse> getAllHumidityData() {
        List<Maternity_HumidityResponse> responses = new ArrayList<>();
        responses.add(new Maternity_HumidityResponse(55.0, "%", System.currentTimeMillis()));
        responses.add(new Maternity_HumidityResponse(56.0, "%", System.currentTimeMillis() - 10000));
        return responses;
    }*/

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Maternity_HumidityResponse> maternityHumidityResponse = getAllHumidityData();
        maternityExcelExporter.exportMaternity_humidityData(maternityHumidityResponse, filePath);
    }
}
