package com.farminserver.api.domain.gestation_sensor.gestation_temperature_sensor.controller.model;

public class Gestation_TemperatureResponse {
    private String gestationRoomNum;
    private double GestationTemperatureData;
    private String unit;
    private long timestamp;
    private long gestationTemperatureLocateData;

    public Gestation_TemperatureResponse(String gestationRoomNum, double gestationTemperatureData, String unit, long timestamp, long gestationTemperatureLocateData) {
        this.gestationRoomNum = gestationRoomNum;
        this.GestationTemperatureData = gestationTemperatureData;
        this.unit = unit;
        this.timestamp = timestamp;
        this.gestationTemperatureLocateData = gestationTemperatureLocateData;
    }
    // Getters and Setters
    public String getGestationRoomNum() {
        return gestationRoomNum;
    }
    public void setGestationRoomNum(String gestationRoomNum) {
        this.gestationRoomNum = gestationRoomNum;
    }

    public double getGestationTemperatureData() {
        return GestationTemperatureData;
    }
    public void setGestationTemperatureData(double gestationTemperatureData) {
        this.GestationTemperatureData = gestationTemperatureData;
    }

    public long getGestationTemperatureLocateData() {
        return gestationTemperatureLocateData;
    }
    public void setGestationTemperatureLocateData(long gestationTemperatureLocateData) {
        this.gestationTemperatureLocateData = gestationTemperatureLocateData;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
