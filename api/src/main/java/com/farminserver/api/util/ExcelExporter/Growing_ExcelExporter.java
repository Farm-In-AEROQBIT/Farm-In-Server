package com.farminserver.api.util.ExcelExporter;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller.model.Growing_Co2Response;
import com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller.model.Growing_Nh3Response;
import com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller.model.Growing_HumidityResponse;
import com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller.model.Growing_TemperatureResponse;
import com.farminserver.api.domain.growing_sensor.growing_pm_sensor.controller.model.Growing_PmResponse;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class Growing_ExcelExporter {

    public void exportGrowing_Nh3Data(List<Growing_Nh3Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nh3 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Nh3");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Growing_Nh3Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGrowingRoomNum());
            row.createCell(1).setCellValue(response.getGrowingNh3Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGrowing_co2Data(List<Growing_Co2Response> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Co2 Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Co2 Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Growing_Co2Response response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGrowingBarnRoomNum());
            row.createCell(1).setCellValue(response.getGrowingCo2Data());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGrowing_humidityData(List<Growing_HumidityResponse> responses, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Humidity Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Humidity Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");

        for (Growing_HumidityResponse response : responses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGrowingBarnRoomNum());
            row.createCell(1).setCellValue(response.getGrowingHumidityData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGrowing_TemperatureData(List<Growing_TemperatureResponse> growingTemperatureResponse, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Temperature Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Room Number");
        headerRow.createCell(1).setCellValue("Temperature Data");
        headerRow.createCell(2).setCellValue("Unit");
        headerRow.createCell(3).setCellValue("Timestamp");
        headerRow.createCell(4).setCellValue("Temperature locate Data");

        for (Growing_TemperatureResponse response : growingTemperatureResponse) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGrowingRoomNum());
            row.createCell(1).setCellValue(response.getGrowingTemperatureData());
            row.createCell(2).setCellValue(response.getUnit());
            row.createCell(3).setCellValue(response.getTimestamp());
            row.createCell(4).setCellValue(response.getGrowingTemperatureLocateData());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void exportGrowing_PmData(List<Growing_PmResponse> growingPmResponse, String filePath) throws IOException {
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

        for (Growing_PmResponse response : growingPmResponse) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(response.getGrowingRoomNum());
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
