package com.farminserver.api.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller.model.Finishing_Co2Response;
import com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller.model.Finishing_Co2Response;
import com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model.Finishing_HumidityResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller.model.Finishing_TemperatureResponse;
import com.farminserver.api.domain.finishing_sensor.finishing_pm_sensor.controller.model.Finishing_PmResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Finishing_ExcelExporter {

        public void exportFinishing_Nh3Data(List<Finishing_Nh3Response> responses, String filePath) throws IOException {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Nh3 Data");

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Room Number");
            headerRow.createCell(1).setCellValue("Nh3");
            headerRow.createCell(2).setCellValue("Unit");
            headerRow.createCell(3).setCellValue("Timestamp");

            for (Finishing_Nh3Response response : responses) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(response.getFinishingBarnRoomNum());
                row.createCell(1).setCellValue(response.getFinishingNh3Data());
                row.createCell(2).setCellValue(response.getUnit());
                row.createCell(3).setCellValue(response.getTimestamp());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            workbook.close();
        }

        public void exportFinishing_co2Data(List<Finishing_Co2Response> responses, String filePath) throws IOException {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Co2 Data");

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Room Number");
            headerRow.createCell(1).setCellValue("Co2 Data");
            headerRow.createCell(2).setCellValue("Unit");
            headerRow.createCell(3).setCellValue("Timestamp");

            for (Finishing_Co2Response response : responses) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(response.getFinishingBarnRoomNum());
                row.createCell(1).setCellValue(response.getFinishingCo2Data());
                row.createCell(2).setCellValue(response.getUnit());
                row.createCell(3).setCellValue(response.getTimestamp());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            workbook.close();
        }

        public void exportFinishing_humidityData(List<Finishing_HumidityResponse> responses, String filePath) throws IOException {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Humidity Data");

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Room Number");
            headerRow.createCell(1).setCellValue("Humidity Data");
            headerRow.createCell(2).setCellValue("Unit");
            headerRow.createCell(3).setCellValue("Timestamp");

            for (Finishing_HumidityResponse response : responses) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(response.getFinishingBarnRoomNum());
                row.createCell(1).setCellValue(response.getFinishingHumidityData());
                row.createCell(2).setCellValue(response.getUnit());
                row.createCell(3).setCellValue(response.getTimestamp());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            workbook.close();
        }

        public void exportFinishing_TemperatureData(List<Finishing_TemperatureResponse> boarsTemperatureRespons, String filePath) throws IOException {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Temperature Data");

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Room Number");
            headerRow.createCell(1).setCellValue("Temperature Data");
            headerRow.createCell(2).setCellValue("Unit");
            headerRow.createCell(3).setCellValue("Timestamp");
            headerRow.createCell(4).setCellValue("Temperature locate Data");

            for (Finishing_TemperatureResponse response : boarsTemperatureRespons) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(response.getFinishingBarnRoomNum());
                row.createCell(1).setCellValue(response.getFinishingTemperatureData());
                row.createCell(2).setCellValue(response.getUnit());
                row.createCell(3).setCellValue(response.getTimestamp());
                row.createCell(4).setCellValue(response.getboarsTemperatureLocateData());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            workbook.close();
        }

        public void exportFinishing_PmData(List<Finishing_PmResponse> boarsPmRespons, String filePath) throws IOException {
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

            for (Finishing_PmResponse response : boarsPmRespons) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(response.getFinishingBarnRoomNum());
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