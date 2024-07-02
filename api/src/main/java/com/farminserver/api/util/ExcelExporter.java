package com.farminserver.api.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.UserResponse;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.HumidityResponse;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.TemperatureResponse;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.PmResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public void exportnh3Data(List<Nh3Response> nh3Responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nh3 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Nh3");
        headerRow.createCell(1).setCellValue("Unit");
        headerRow.createCell(2).setCellValue("Timestamp");

        for (Nh3Response response : nh3Responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getNh3());
            row.createCell(1).setCellValue(response.getUnit());
            row.createCell(2).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportco2Data(List<UserResponse> userRespons, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Co2 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Co2");
        headerRow.createCell(1).setCellValue("Unit");
        headerRow.createCell(2).setCellValue("Timestamp");

        for (UserResponse response : userRespons) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getCo2());
            row.createCell(1).setCellValue(response.getUnit());
            row.createCell(2).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exporthumidityData(List<HumidityResponse> humidityResponses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Humidity Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Humidity");
        headerRow.createCell(1).setCellValue("Unit");
        headerRow.createCell(2).setCellValue("Timestamp");

        for (HumidityResponse response : humidityResponses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getHumidity());
            row.createCell(1).setCellValue(response.getUnit());
            row.createCell(2).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportTemperatureData(List<TemperatureResponse> temperatureResponses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Temperature Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Temperature");
        headerRow.createCell(1).setCellValue("Unit");
        headerRow.createCell(2).setCellValue("Timestamp");

        for (TemperatureResponse response : temperatureResponses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getTemperature());
            row.createCell(1).setCellValue(response.getUnit());
            row.createCell(2).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportPmData(List<PmResponse> pmResponses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PM Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("PM1.0");
        headerRow.createCell(1).setCellValue("PM2.5");
        headerRow.createCell(2).setCellValue("PM10");
        headerRow.createCell(3).setCellValue("Total PM");
        headerRow.createCell(4).setCellValue("Timestamp");

        for (PmResponse response : pmResponses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getPm1_0());
            row.createCell(1).setCellValue(response.getPm2_5());
            row.createCell(2).setCellValue(response.getPm10());
            row.createCell(3).setCellValue(response.getTotalPm());
            row.createCell(4).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();


    }
}
