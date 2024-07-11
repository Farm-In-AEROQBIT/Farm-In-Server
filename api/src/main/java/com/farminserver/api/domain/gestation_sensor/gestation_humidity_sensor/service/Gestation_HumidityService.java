package com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.service;

import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller.model.Gestation_HumidityResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.converter.Gestation_HumidityConverter;
import com.farminserver.db.gestation_humidity_sensor.Gestation_HumiditySensorEntity;
import com.farminserver.db.gestation_humidity_sensor.Gestation_HumiditySensorRepository;
import com.farminserver.api.util.Gestation_ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gestation_HumidityService {

    private final Gestation_HumiditySensorRepository repository;
    private final Gestation_HumidityConverter converter;
    private final Gestation_ExcelExporter gestationExcelExporter;
    private final Gestation_HumiditySensorRepository gestation_HumiditySensorRepository;

    @Autowired
    public Gestation_HumidityService(Gestation_HumiditySensorRepository repository, Gestation_HumidityConverter converter, Gestation_ExcelExporter excelExporter, Gestation_HumiditySensorRepository gestation_HumiditySensorRepository) {
        this.repository = repository;
        this.converter = converter;
        this.gestationExcelExporter = excelExporter;
        this.gestation_HumiditySensorRepository = gestation_HumiditySensorRepository;
    }

    public Gestation_HumidityResponse getHumidityData(Long gestationBarnRoomNum) {
        Gestation_HumiditySensorEntity entity = repository.findById(gestationBarnRoomNum).orElseThrow(() -> new RuntimeException("Sensor data not found"));
        return converter.convert(entity);
    }

    public List<Gestation_HumidityResponse> getAllHumidityData() {
        List<Gestation_HumiditySensorEntity> entities = repository.findAll();
        List<Gestation_HumidityResponse> responses = new ArrayList<>();
        for (Gestation_HumiditySensorEntity entity : entities) {
            responses.add(converter.convert(entity));
        }
        return responses;
    }

    public void exportHumidityDataToExcel(String filePath) throws IOException {
        List<Gestation_HumidityResponse> gestationHumidityRespons = getAllHumidityData();
        gestationExcelExporter.exportGestation_humidityData(gestationHumidityRespons, filePath);
    }
}
