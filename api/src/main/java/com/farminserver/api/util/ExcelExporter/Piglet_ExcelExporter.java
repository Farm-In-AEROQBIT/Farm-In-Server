package com.farminserver.api.util.ExcelExporter;

import com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller.model.Piglet_Co2Response;
import com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller.model.Piglet_HumidityResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller.model.Piglet_Nh3Response;
import com.farminserver.api.domain.piglet_sensor.piglet_pm_sensor.controller.model.Piglet_PmResponse;
import com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller.model.Piglet_TemperatureResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component

public class Piglet_ExcelExporter {

    public void exportPiglet_Nh3Data(List<Piglet_Nh3Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nh3 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Nh3");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Piglet_Nh3Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getPiglet_RoomNum());
            row.createCell(1).setCellValue(response.getPigletNh3Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportPiglet_co2Data(List<Piglet_Co2Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Co2 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Co2 Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Piglet_Co2Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getPigletRoomNum());
            row.createCell(1).setCellValue(response.getPigletCo2Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportPiglet_humidityData(List<Piglet_HumidityResponse> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Humidity Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Humidity Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Piglet_HumidityResponse response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getPigletRoomNum());
            row.createCell(1).setCellValue(response.getPigletHumidityData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportPiglet_TemperatureData(List<Piglet_TemperatureResponse> boarsTemperatureResponse, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Temperature Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Temperature Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");
        headerRow.createCell(4).setCellValue("Temperature locate Data");

        for (Piglet_TemperatureResponse response : boarsTemperatureResponse) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getPigletRoomNum());
            row.createCell(1).setCellValue(response.getPigletTemperatureData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
            row.createCell(4).setCellValue(response.getpigletTemperatureLocateData());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportPiglet_PmData(List<Piglet_PmResponse> pigletPmResponse, String filePath) throws IOException {
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

        for (Piglet_PmResponse response : pigletPmResponse) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getPigletRoomNum());
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
