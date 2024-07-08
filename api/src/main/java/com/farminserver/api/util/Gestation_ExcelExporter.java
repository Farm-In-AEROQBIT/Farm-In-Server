package com.farminserver.api.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller.model.Gestation_Co2Response;
import com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller.model.Gestation_Nh3Response;
import com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller.model.Gestation_HumidityResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller.model.Gestation_TemperatureResponse;
import com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller.model.Gestation_PmResponse;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class Gestation_ExcelExporter {

    public void exportGestation_Nh3Data(List<Gestation_Nh3Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nh3 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Nh3");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Gestation_Nh3Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGestationBarnRoomNum());
            row.createCell(1).setCellValue(response.getGestationNh3Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGestation_co2Data(List<Gestation_Co2Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Co2 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Co2 Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Gestation_Co2Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGestationBarnRoomNum());
            row.createCell(1).setCellValue(response.getGestationCo2Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGestation_humidityData(List<Gestation_HumidityResponse> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Humidity Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Humidity Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Gestation_HumidityResponse response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGestationBarnRoomNum());
            row.createCell(1).setCellValue(response.getGestationHumidityData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGestation_TemperatureData(List<Gestation_TemperatureResponse> boarsTemperatureRespons, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Temperature Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Temperature Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");
        headerRow.createCell(4).setCellValue("Temperature locate Data");

        for (Gestation_TemperatureResponse response : boarsTemperatureRespons) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGestationBarnRoomNum());
            row.createCell(1).setCellValue(response.getGestationTemperData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
            row.createCell(4).setCellValue(response.getGestationTemperLocateData());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGestation_PmData(List<Gestation_PmResponse> boarsPmRespons, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PM Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("PM1.0");
        headerRow.createCell(2).setCellValue("PM2.5");
        headerRow.createCell(3).setCellValue("PM10");
        headerRow.createCell(4).setCellValue("Total PM");
        headerRow.createCell(5).setCellValue("Timestamp");

        for (Gestation_PmResponse response : boarsPmRespons) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGestationBarnRoomNum());
            row.createCell(1).setCellValue(response.getPm1_0());
            row.createCell(2).setCellValue(response.getPm2_5());
            row.createCell(3).setCellValue(response.getPm10());
            row.createCell(4).setCellValue(response.getTotalPm());
            row.createCell(5).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();


    }
}
