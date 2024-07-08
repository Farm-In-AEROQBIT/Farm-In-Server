package com.farminserver.api.util;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Boars_Co2Response;
import com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model.Boars_HumidityResponse;
import com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model.Boars_Nh3Response;
import com.farminserver.api.domain.boars_sensor.boars_pm_sensor.controller.model.Boars_PmResponse;
import com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model.Boars_TemperatureResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class Reserve_ExcelExporter {

    public void exportReserve_Nh3Data(List<Reserve_Nh3Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nh3 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Nh3");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Reserve_Nh3Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getReserveRoomNum());
            row.createCell(1).setCellValue(response.getReserveNh3Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportReserve_co2Data(List<Reserve_Co2Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Co2 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Co2 Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Reserve_Co2Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getReserveBarnRoomNum());
            row.createCell(1).setCellValue(response.getReserveCo2Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportReserve_humidityData(List<Reserve_HumidityResponse> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Humidity Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Humidity Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Reserve_HumidityResponse response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getReserveBarnRoomNum());
            row.createCell(1).setCellValue(response.getReserveHumidityData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportReserve_TemperatureData(List<Reserve_TemperatureResponse> reserveTemperatureRespons, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Temperature Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Temperature Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");
        headerRow.createCell(4).setCellValue("Temperature locate Data");

        for (Reserve_TemperatureResponse response : reserveTemperatureRespons) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getReserveBarnRoomNum());
            row.createCell(1).setCellValue(response.getReserveTemperatureData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
            row.createCell(4).setCellValue(response.getReserveTemperatureLocateData());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportReserve_PmData(List<Reserve_PmResponse> reservePmRespons, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PM Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("PM1.0");
        headerRow.createCell(1).setCellValue("PM2.5");
        headerRow.createCell(2).setCellValue("PM10");
        headerRow.createCell(3).setCellValue("Total PM");
        headerRow.createCell(4).setCellValue("Timestamp");

        for (Reserve_PmResponse response : reservePmRespons) {
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
