package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model;

public class Boars_TemperatureResponse {
    private String boarsBarnRoomNum;
    private double BoarsTemperatureData;
    private String unit;
    private long timestamp;
    private long boarsTemperatureLocateData;

    public Boars_TemperatureResponse(String boarsBarnRoomNum, double boarstemperaturedata, String unit, long timestamp, long boarsTemperatureLocateData) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
        this.BoarsTemperatureData = boarstemperaturedata;
        this.unit = unit;
        this.timestamp = timestamp;
        this.boarsTemperatureLocateData = boarsTemperatureLocateData;
    }

    // Getters and Setters

    public String getBoarsBarnRoomNum() {
        return boarsBarnRoomNum;
    }
    public void setBoarsBarnRoomNum(String boarsBarnRoomNum) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
    }

    public double getBoarsTemperatureData() {
        return BoarsTemperatureData;
    }
    public void setBoarsTemperatureData(double boarsTemperatureData) {
        this.BoarsTemperatureData = boarsTemperatureData;
    }

    public long getboarsTemperatureLocateData() {
        return boarsTemperatureLocateData;
    }
    public void setboarsTemperatureLocateData(long boarsTemperatureLocateData) {
        this.boarsTemperatureLocateData = boarsTemperatureLocateData;
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
